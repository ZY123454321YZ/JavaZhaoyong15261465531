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
    Element root = document.createElement("mode");     //创建根节点     
    document.appendChild(root);                               //将根节点添加到Document对象中   
    Element pageElement = document.createElement("page");     //设置第一个page元素到  
    pageElement.setAttribute("name", "list.jsp");             //设置page节点的name属性  
    Element methodElement = document.createElement("method");   //设置method节点  
    methodElement.setTextContent("get");                        //给method设置值  
    pageElement.appendChild(methodElement);                     //添加method节点到page节点内  
    Element displayElement = document.createElement("display");    //设置method节点  
    displayElement.setTextContent("list撒旦发放");                         //给display设置值  
    pageElement.appendChild(displayElement);            //添加display节点到page节点内   
    Element request_paramElement = document.createElement("request_param");  
    request_paramElement.setTextContent("request_param1|request_param2");  
    pageElement.appendChild(request_paramElement);  
    root.appendChild(pageElement);  
    pageElement = document.createElement("page");                    //设置第二个page元素到  
    pageElement.setAttribute("name", "content.jsp");                 //设置page节点的name属性  
    methodElement = document.createElement("method");  
    methodElement.setTextContent("post");  
    pageElement.appendChild(methodElement);  
    displayElement = document.createElement("display");  
    displayElement.setTextContent("content");  
    pageElement.appendChild(displayElement);  
    Element url_titleElement = document.createElement("url_title");        //设置url_title节点  
    url_titleElement.setTextContent("title,publisher,published_calendar"); //给url_title设置值  
    pageElement.appendChild(url_titleElement);                             //添加url_title节点到page节点内  
    root.appendChild(pageElement);                                         //将page段加人根节点内  
    TransformerFactory transFactory = TransformerFactory.newInstance();     //开始把Document映射到文件  
    Transformer transFormer = transFactory.newTransformer();  
    DOMSource domSource = new DOMSource(document);                           //设置输出结果  
    File file = new File("D:\\MobileNetRule.xml"); //生成xml文件  
    if (!file.exists())
    {  
        file.createNewFile();  
    }  
    FileOutputStream out = new FileOutputStream(file);          //文件输出流              
    StreamResult xmlResult = new StreamResult(out);            //设置输入源     
    transFormer.transform(domSource, xmlResult);              //输出xml文件              
    System.out.println(file.getAbsolutePath());               //测试文件输出的路径  
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
	    //得到需要插入属性的节点  
        Element bookname = (Element) document.getElementsByTagName("page").item(0);  
         System.out.println(bookname.getAttribute("name"));
        //插入属性值  
//        bookname.setAttribute("name", "XXXXX");  
         bookname.getElementsByTagName("display").item(0).setTextContent("nanjing");
        //把更新后的内存重新写到文件中  
        TransformerFactory tsfactory = TransformerFactory.newInstance();  
        Transformer transform = tsfactory.newTransformer();  
        transform.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file.getPath())));  
}  
}  
