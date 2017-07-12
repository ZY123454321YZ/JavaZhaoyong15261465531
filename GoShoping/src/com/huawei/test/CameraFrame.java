package com.huawei.test;

import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class CameraFrame {
	public static void main(String[] args) throws Exception, InterruptedException
	{
	    OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);  
	    grabber.start();   //开始获取摄像头数据
	    CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
	    canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    canvas.setAlwaysOnTop(true);
	    
	    while(true)
	    {
	        if(!canvas.isDisplayable())
	        {
	            grabber.stop();
	            System.exit(2);
	        }
	        canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示
	        Thread.sleep(50);//0.05秒刷新一次图像
	    }
}

}