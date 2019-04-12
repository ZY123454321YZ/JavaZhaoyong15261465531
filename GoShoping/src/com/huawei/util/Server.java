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
            //�÷������˳���ʼ��������5200�˿ڵĿͻ�������  
            if (ss==null) {  
                 ss = new ServerSocket(5200);  
                 System.out.println("����������...");  
            }  
              
            //�����������ѭ���ȴ��ͻ��˵�����  
            while(true){      
            /* 
             *accept()�������ڵȴ��û���socket����ʱ�����ţ����û����� 
             *����ʱ���˷����᷵��һ��socket(�ڲ�ͬ�Ķ˿���)�Ա���ͻ��� 
             *ͨ�š�Socket��ServerSocket�Ķ˿ڲ�ͬ�����ServerSocket���� 
             *���г����ȴ������ͻ��� 
             */  
            //���������ͣ�����ȴ�Ҫ�󵽴�֮���ټ���  
            Socket s = ss.accept();  
              
            inputStreamReader = new InputStreamReader(s.getInputStream());  
            bufferedReader = new BufferedReader(inputStreamReader);  
              
            String request = bufferedReader.readLine();  
  
            System.out.println("���յ��˿ͻ��˵�����:"+request);  
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

