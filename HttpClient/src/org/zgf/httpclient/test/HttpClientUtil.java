package org.zgf.httpclient.test;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.Soundbank;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

public class HttpClientUtil {

	private static final String CONTENT_TYPE_KEY = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "text/xml;charset=UTF-8";

	private static final String USER_AGENT_KEY = "User-Agent";
	private static final String USER_AGENT_VALUE = "Apache-HttpClient/4.1.1";

	private static final String ACCEPT_KEY = "Accept";
	private static final String ACCEPT_VALUE = "*/*";

	private static final String ACCEPT_LANGUAGE_KEY = "Accept-Language";
	private static final String ACCEPT_LANGUAGE_VALUE = "zh-cn";

	//设置使用gzip参数，告知服务器端响应内容应先进行gzip压缩
	private static final String ACCEPT_ENCODING_KEY = "Accept-Encoding";
	private static final String ACCEPT_ENCODING_VALUE = "gzip, deflate";

	// 设置代理
	private static final String PROXYHOSTNAME = "172.17.18.80";
	private static final int PROXYPORT = 8080;

	// 默认编码
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	
	/** 获取http Post 对象  */
	private static HttpPost getHttpPost(String serviceWsdl, String requestXml){
		try {
			HttpPost httpPost = new HttpPost(serviceWsdl);
			httpPost.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
			httpPost.setHeader(ACCEPT_LANGUAGE_KEY, ACCEPT_LANGUAGE_VALUE);
			httpPost.setHeader(ACCEPT_KEY, ACCEPT_VALUE);
			httpPost.setHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
			httpPost.setHeader(ACCEPT_ENCODING_KEY, ACCEPT_ENCODING_VALUE);
			
			//设置请求参数
			byte[] bytes = requestXml.getBytes(DEFAULT_ENCODING);
			ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes, 0, bytes.length);
			httpPost.setEntity(byteArrayEntity);
			
			return httpPost;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 获取httpclient 对象 */
	private static DefaultHttpClient getProxyHttpClient(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		// 设置请求链接超时
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 600000);
		// 设置请求读取超时
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 600000);
		// 设置socket链接时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_KEEPALIVE, 600000);

		//设置网络代理
		HttpHost proxy = new HttpHost(PROXYHOSTNAME, PROXYPORT);
		httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		return httpClient;
	}
	
	/** 解析响应结果  */
	private static String parseHttpResponse(HttpResponse httpResponse){
		try {
			InputStream is = httpResponse.getEntity().getContent();
			byte[] byteArray = IOUtils.toByteArray(is);
			System.out.println("解压前的返回结果:\n" + new String(byteArray));
			
			if(null != byteArray){
				//将响应结果解码成字符串
				String uncompressResult = GZipUtil.unGZip(byteArray);
				System.out.println("解压后的返回结果：\n" + uncompressResult);
				
				//将字符串中的特殊字符做替换
				uncompressResult = uncompressResult.replace("lt;", "<");
				uncompressResult = uncompressResult.replace("gt;", ">");
				
				//去除包裹响应结果的标签 
				uncompressResult =  removeSoapTag(uncompressResult);
				System.out.println("去除SOAP 标签的结果：\n" + uncompressResult);
				return uncompressResult;
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Description	请求XML 包裹SOAP 标签， 每个 webservice 服务的包裹方式不一定一样， 具体包裹方式如何，可以通过SOAPUI 软件进行查看
	 * @param rquestXML	请求XML 片段
	 * @return 	SOAP 标签包裹的XML 片段
	 */
	private static String  wrapSoapTag(String rquestXML){
		StringBuilder sb = new StringBuilder();
		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<soapenv:Header/>");
		sb.append("<soapenv:Body>");
		sb.append("<ns2:sayHello xmlns:ns2=\"http://service.sunny.org/\">");
		sb.append("<arg0>");
		sb.append("<![CDATA[");
		sb.append(rquestXML.trim());
		sb.append("]]>");
		sb.append("</arg0>");
		sb.append("</ns2:sayHello>");
		sb.append("</soapenv:Body>");
		sb.append("</soapenv:Envelope>");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	/**
	 * @Description	去掉响应 结果中最外层包裹的SOAP 标签
	 * @param responseXML
	 * @return 响应结果字符串
	 */
	private static String removeSoapTag(String responseXML){
		if(null == responseXML || "".equals(responseXML)){
			return responseXML;
		}
		String beginTag = "<return>";
		String endTag = "</return>";
		return StringUtils.substringBetween(responseXML, beginTag, endTag);
	}
	
	
	/** 发送web service 请求*/
	public static String sendPostRequest(String serviceWsdl, String requestXml){
		//包裹SOAP 标签
		requestXml = wrapSoapTag(requestXml);
		
		HttpPost httpPost = getHttpPost(serviceWsdl, requestXml);
		HttpClient httpClient = getProxyHttpClient();
		HttpResponse httpResponse  = null;
		try {
			httpResponse = httpClient.execute(httpPost);
			System.out.println(httpResponse.getStatusLine().getStatusCode());
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				return parseHttpResponse(httpResponse);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
