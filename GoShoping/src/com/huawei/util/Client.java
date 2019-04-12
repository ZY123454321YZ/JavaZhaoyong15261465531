package com.huawei.util;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
public class Client {  
  
    public void go() throws UnknownHostException, IOException{  
          
        //向服务器端发送请求，服务器IP地址和服务器监听的端口号  
        Socket client = new Socket("127.0.0.1", 5200);  
          
                  //通过printWriter 来向服务器发送消息  
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());  
        System.out.println("连接已建立...");  
                    
                  //发送消息  
        printWriter.println("hello Server");  
          
        printWriter.flush();  
          
        //InputStreamReader是低层和高层串流之间的桥梁  
        //client.getInputStream()从Socket取得输入串流  
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());  
          
        //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder  
        BufferedReader reader = new BufferedReader(streamReader);  
        String advice =reader.readLine();  
          
          
        System.out.println("接收到服务器的消息 ："+advice);  
        reader.close();  
    }  
      
    public static void main(String[] args) throws UnknownHostException, IOException {  
        Client c = new Client();  
        c.go();  
    }  
}  