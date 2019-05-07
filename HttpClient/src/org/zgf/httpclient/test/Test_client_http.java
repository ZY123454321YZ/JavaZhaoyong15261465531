package org.zgf.httpclient.test;

public class Test_client_http {
	
	public static void main(String[] args) {
		String requestXml = "hello";
		String serviceWsdl = "http://localhost:9092/Service/SayHello?wsdl";
		HttpClientUtil.sendPostRequest(serviceWsdl, requestXml);
	}

}