package com.huawei.util;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
  
public class Server {  
      
  
    private ServerSocket ss;  
      
    private InputStreamReader inputStreamReader;   
      
    private BufferedReader bufferedReader;  
      
    public void server(){  
  
        try {  
            //让服务器端程序开始监听来自5200端口的客户端请求  
            if (ss==null) {  
                 ss = new ServerSocket(5200);  
                 System.out.println("服务器启动...");  
            }  
              
            //服务器无穷的循环等待客户端的请求  
            while(true){      
            /* 
             *accept()方法会在等待用户的socket连接时闲置着，当用户链接 
             *上来时，此方法会返回一个socket(在不同的端口上)以便与客户端 
             *通信。Socket与ServerSocket的端口不同，因此ServerSocket可以 
             *空闲出来等待其他客户端 
             */  
            //这个方法会停下来等待要求到达之后再继续  
            Socket s = ss.accept();  
              
            inputStreamReader = new InputStreamReader(s.getInputStream());  
            bufferedReader = new BufferedReader(inputStreamReader);  
              
            String request = bufferedReader.readLine();  
  
            System.out.println("接收到了客户端的请求:"+request);  
            PrintWriter printWriter = new PrintWriter(s.getOutputStream());  
              
            String advice = "I am Server";  
            printWriter.println(advice);  
            printWriter.close();  
              
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
    }  
      
    public static void main(String[] args) {  
        Server server = new Server();  
        server.server();  
    }  
      
      
}  

