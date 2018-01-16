package com.huawei.util;
import javax.media.ConfigureCompleteEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.DataSink;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Processor;
import javax.media.RealizeCompleteEvent;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
public class RTPServer implements ControllerListener {
	private boolean realized = false;
	private boolean configured = false;
	public RTPServer() {
		Processor p;
		String srcFile = "long.wav";
		// String destUrl = "rtp://224.144.251.104:49150/audio/1";
		String destUrl = "rtp://128.0.0.1:49150/audio";
		DataSink rtpSink;
		MediaLocator src = new MediaLocator("file:" + srcFile);
		MediaLocator dest = new MediaLocator(destUrl);
		// MediaLocator dest = new MediaLocator("rtpraw://");
		try 
		{
			p = Manager.createProcessor(src);
			p.addControllerListener(this);
			p.configure();
			while (!configured)
			{
				try 
				{
					Thread.currentThread().sleep(100L);
				} 
				catch (InterruptedException e)
				{
					// ignore
				}
			}
			p.setContentDescriptor(new ContentDescriptor(FileTypeDescriptor.RAW_RTP));
			p.realize();
			while (!realized)
			{
				try 
				{
					Thread.currentThread().sleep(100L);
				}
				catch (InterruptedException e)
				{
					// ignore
				}
			}
			DataSource output = p.getDataOutput();
			rtpSink = Manager.createDataSink(output, dest);
			System.out.println("Sink content type: " + rtpSink.getContentType());
			System.out.println("Sink media type: " + rtpSink.getOutputLocator().toString());
			rtpSink.open();
			rtpSink.start();
			p.start();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	public synchronized void controllerUpdate(ControllerEvent evt) 
	{
		if (evt instanceof RealizeCompleteEvent) 
		{
			realized = true;
		} 
		else if (evt instanceof ConfigureCompleteEvent)
		{
			configured = true;
		} 
		else if (evt instanceof EndOfMediaEvent)
		{
			System.exit(0);
		} 
		else 
		{
			// System.out.println(evt.toString());
		}
	}
}
