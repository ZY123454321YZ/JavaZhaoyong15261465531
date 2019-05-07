package com.springmvc.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class WebServiceUtil {
	private static final String CONTENT_TYPE_KEY = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "text/xml;charset=UTF-8";

	private static final String USER_AGENT_KEY = "User-Agent";
	private static final String USER_AGENT_VALUE = "Apache-HttpClient/4.1.1";

	private static final String ACCEPT_KEY = "Accept";
	private static final String ACCEPT_VALUE = "*/*";

	private static final String ACCEPT_LANGUAGE_KEY = "Accept-Language";
	private static final String ACCEPT_LANGUAGE_VALUE = "zh-cn";

	// 设置使用gzip参数，告知服务器端响应内容应先进行gzip压缩
	private static final String ACCEPT_ENCODING_KEY = "Accept-Encoding";
	private static final String ACCEPT_ENCODING_VALUE = "gzip, deflate";

	// 设置代理
	private static final String PROXYHOSTNAME = "127.0.0.1";
	private static final int PROXYPORT = 80;

	// 默认编码
	private static final String DEFAULT_ENCODING = "UTF-8";

	public static void execute(String webServiceUrl, String filePath) throws Exception {
		String line = "";
		// 返回数据
		String retStr = "";
		StringBuilder builder = new StringBuilder();
		File f = new File(filePath);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(webServiceUrl);
		HttpEntity entity = new StringEntity(builder.toString(), HTTP.UTF_8);
		post.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
		//可选
//		post.setHeader(ACCEPT_LANGUAGE_KEY, ACCEPT_LANGUAGE_VALUE);
//		post.setHeader(ACCEPT_KEY, ACCEPT_VALUE);
//		post.setHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
		post.setEntity(entity);
		HttpResponse response = client.execute(post);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			// 打印响应内容
			retStr = EntityUtils.toString(httpEntity, "UTF-8");
			System.out.println("返回码为: " + response.getStatusLine().getStatusCode());
			System.out.println("返回内容为: " + retStr);
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
        String webServiceUrl = "http://localhost:9092/Service/SayHello?wsdl";
        String filePath = "C:\\\\Users\\\\Administrator\\\\Desktop\\\\webservice\\\\request.xml";
		execute(webServiceUrl, filePath);
		
	}

}
