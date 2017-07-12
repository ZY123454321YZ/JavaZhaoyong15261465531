package com.huawei.test;

import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class CameraFrame {
	public static void main(String[] args) throws Exception, InterruptedException
	{
	    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);  
	    grabber.start();   //��ʼ��ȡ����ͷ����
	    CanvasFrame canvas = new CanvasFrame("����ͷ");//�½�һ������
	    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    canvas.setAlwaysOnTop(true);
	    
	    while(true)
	    {
	        if(!canvas.isDisplayable())
	        {
	            grabber.stop();
	            System.exit(2);
	        }
	        canvas.showImage(grabber.grab());//��ȡ����ͷͼ�񲢷ŵ���������ʾ
	        Thread.sleep(50);//0.05��ˢ��һ��ͼ��
	    }
}

}