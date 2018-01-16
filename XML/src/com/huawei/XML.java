package com.huawei;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XML {
	public void generate() throws Exception{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
    DocumentBuilder builder = factory.newDocumentBuilder();  
    Document document = builder.newDocument();  
    document.setXmlVersion("1.0");  
    document.setXmlStandalone(true);  
    Element root = document.createElement("mode");     //�������ڵ�     
    document.appendChild(root);                               //�����ڵ���ӵ�Document������   
    Element pageElement = document.createElement("page");     //���õ�һ��pageԪ�ص�  
    pageElement.setAttribute("name", "list.jsp");             //����page�ڵ��name����  
    Element methodElement = document.createElement("method");   //����method�ڵ�  
    methodElement.setTextContent("get");                        //��method����ֵ  
    pageElement.appendChild(methodElement);                     //���method�ڵ㵽page�ڵ���  
    Element displayElement = document.createElement("display");    //����method�ڵ�  
    displayElement.setTextContent("list��������");                         //��display����ֵ  
    pageElement.appendChild(displayElement);            //���display�ڵ㵽page�ڵ���   
    Element request_paramElement = document.createElement("request_param");  
    request_paramElement.setTextContent("request_param1|request_param2");  
    pageElement.appendChild(request_paramElement);  
    root.appendChild(pageElement);  
    pageElement = document.createElement("page");                    //���õڶ���pageԪ�ص�  
    pageElement.setAttribute("name", "content.jsp");                 //����page�ڵ��name����  
    methodElement = document.createElement("method");  
    methodElement.setTextContent("post");  
    pageElement.appendChild(methodElement);  
    displayElement = document.createElement("display");  
    displayElement.setTextContent("content");  
    pageElement.appendChild(displayElement);  
    Element url_titleElement = document.createElement("url_title");        //����url_title�ڵ�  
    url_titleElement.setTextContent("title,publisher,published_calendar"); //��url_title����ֵ  
    pageElement.appendChild(url_titleElement);                             //���url_title�ڵ㵽page�ڵ���  
    root.appendChild(pageElement);                                         //��page�μ��˸��ڵ���  
    TransformerFactory transFactory = TransformerFactory.newInstance();     //��ʼ��Documentӳ�䵽�ļ�  
    Transformer transFormer = transFactory.newTransformer();  
    DOMSource domSource = new DOMSource(document);                           //����������  
    File file = new File("D:\\MobileNetRule.xml"); //����xml�ļ�  
    if (!file.exists())
    {  
        file.createNewFile();  
    }  
    FileOutputStream out = new FileOutputStream(file);          //�ļ������              
    StreamResult xmlResult = new StreamResult(out);            //��������Դ     
    transFormer.transform(domSource, xmlResult);              //���xml�ļ�              
    System.out.println(file.getAbsolutePath());               //�����ļ������·��  
    TransformerFactory  tf  =  TransformerFactory.newInstance();  
    Transformer t = tf.newTransformer();  
    t.setOutputProperty("{/encoding/}","GB2312/");  
    ByteArrayOutputStream boc  = new ByteArrayOutputStream();  
    t.transform(new DOMSource(document), new StreamResult(boc));  
    String xmlstring = boc.toString();  
    System.out.println(xmlstring);  
} 
public static void main(String[] args) throws Exception
{  
//           new XML().generate();
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	    File file = new File("D:\\MobileNetRule.xml");
	    DocumentBuilder builder = factory.newDocumentBuilder();  
	    Document document = builder.parse("D:\\MobileNetRule.xml");
	    //�õ���Ҫ�������ԵĽڵ�  
        Element bookname = (Element) document.getElementsByTagName("page").item(0);  
         System.out.println(bookname.getAttribute("name"));
        //��������ֵ  
//        bookname.setAttribute("name", "XXXXX");  
         bookname.getElementsByTagName("display").item(0).setTextContent("nanjing");
        //�Ѹ��º���ڴ�����д���ļ���  
        TransformerFactory tsfactory = TransformerFactory.newInstance();  
        Transformer transform = tsfactory.newTransformer();  
        transform.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file.getPath())));  
}  
}  
