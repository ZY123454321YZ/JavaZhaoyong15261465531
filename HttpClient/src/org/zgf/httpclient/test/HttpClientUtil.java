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

	//����ʹ��gzip��������֪����������Ӧ����Ӧ�Ƚ���gzipѹ��
	private static final String ACCEPT_ENCODING_KEY = "Accept-Encoding";
	private static final String ACCEPT_ENCODING_VALUE = "gzip, deflate";

	// ���ô���
	private static final String PROXYHOSTNAME = "172.17.18.80";
	private static final int PROXYPORT = 8080;

	// Ĭ�ϱ���
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	
	/** ��ȡhttp Post ����  */
	private static HttpPost getHttpPost(String serviceWsdl, String requestXml){
		try {
			HttpPost httpPost = new HttpPost(serviceWsdl);
			httpPost.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
			httpPost.setHeader(ACCEPT_LANGUAGE_KEY, ACCEPT_LANGUAGE_VALUE);
			httpPost.setHeader(ACCEPT_KEY, ACCEPT_VALUE);
			httpPost.setHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
			httpPost.setHeader(ACCEPT_ENCODING_KEY, ACCEPT_ENCODING_VALUE);
			
			//�����������
			byte[] bytes = requestXml.getBytes(DEFAULT_ENCODING);
			ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes, 0, bytes.length);
			httpPost.setEntity(byteArrayEntity);
			
			return httpPost;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** ��ȡhttpclient ���� */
	private static DefaultHttpClient getProxyHttpClient(){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		// �����������ӳ�ʱ
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 600000);
		// ���������ȡ��ʱ
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 600000);
		// ����socket����ʱ��
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_KEEPALIVE, 600000);

		//�����������
		HttpHost proxy = new HttpHost(PROXYHOSTNAME, PROXYPORT);
		httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		return httpClient;
	}
	
	/** ������Ӧ���  */
	private static String parseHttpResponse(HttpResponse httpResponse){
		try {
			InputStream is = httpResponse.getEntity().getContent();
			byte[] byteArray = IOUtils.toByteArray(is);
			System.out.println("��ѹǰ�ķ��ؽ��:\n" + new String(byteArray));
			
			if(null != byteArray){
				//����Ӧ���������ַ���
				String uncompressResult = GZipUtil.unGZip(byteArray);
				System.out.println("��ѹ��ķ��ؽ����\n" + uncompressResult);
				
				//���ַ����е������ַ����滻
				uncompressResult = uncompressResult.replace("lt;", "<");
				uncompressResult = uncompressResult.replace("gt;", ">");
				
				//ȥ��������Ӧ����ı�ǩ 
				uncompressResult =  removeSoapTag(uncompressResult);
				System.out.println("ȥ��SOAP ��ǩ�Ľ����\n" + uncompressResult);
				return uncompressResult;
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Description	����XML ����SOAP ��ǩ�� ÿ�� webservice ����İ�����ʽ��һ��һ���� ���������ʽ��Σ�����ͨ��SOAPUI ������в鿴
	 * @param rquestXML	����XML Ƭ��
	 * @return 	SOAP ��ǩ������XML Ƭ��
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
	 * @Description	ȥ����Ӧ ���������������SOAP ��ǩ
	 * @param responseXML
	 * @return ��Ӧ����ַ���
	 */
	private static String removeSoapTag(String responseXML){
		if(null == responseXML || "".equals(responseXML)){
			return responseXML;
		}
		String beginTag = "<return>";
		String endTag = "</return>";
		return StringUtils.substringBetween(responseXML, beginTag, endTag);
	}
	
	
	/** ����web service ����*/
	public static String sendPostRequest(String serviceWsdl, String requestXml){
		//����SOAP ��ǩ
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
