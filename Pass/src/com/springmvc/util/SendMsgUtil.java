package com.springmvc.util;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
public class SendMsgUtil 
{
	public static void main(String[] args) throws Exception 
	{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// ��ͷ�ļ�������ת��
		NameValuePair[] data = { new NameValuePair("Uid", "zhaoyong"), new NameValuePair("Key", "7453263zy"),
				new NameValuePair("smsMob", "17305196199"), new NameValuePair("smsText", "[zhaoyong]") };
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers)
		{
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
		System.out.println(result); // ��ӡ������Ϣ״̬
		post.releaseConnection();
	}
}