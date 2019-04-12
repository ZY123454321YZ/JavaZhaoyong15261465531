package com.huawei.util;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
public class Client {  
  
    public void go() throws UnknownHostException, IOException{  
          
        //��������˷������󣬷�����IP��ַ�ͷ����������Ķ˿ں�  
        Socket client = new Socket("127.0.0.1", 5200);  
          
                  //ͨ��printWriter ���������������Ϣ  
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());  
        System.out.println("�����ѽ���...");  
                    
                  //������Ϣ  
        printWriter.println("hello Server");  
          
        printWriter.flush();  
          
        //InputStreamReader�ǵͲ�͸߲㴮��֮�������  
        //client.getInputStream()��Socketȡ�����봮��  
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());  
          
        //�������ݴ���������BufferedReader����ȡ����BufferReader���ӵ�InputStreamReder  
        BufferedReader reader = new BufferedReader(streamReader);  
        String advice =reader.readLine();  
          
          
        System.out.println("���յ�����������Ϣ ��"+advice);  
        reader.close();  
    }  
      
    public static void main(String[] args) throws UnknownHostException, IOException {  
        Client c = new Client();  
        c.go();  
    }  
}  