package com.huawei.util;

import java.io.*; 

import javax.media.*; 
import javax.media.format.*; 
import javax.media.protocol.*; 

public class RTPClient implements ControllerListener { 

public static void main(String [] args) { 
new RTPClient(); 
} 

public RTPClient() { 
Player p; 

String srcUrl = "rtp://192.168.2.1:49150/audio"; 
// String srcUrl = "rtp://224.144.251.104:49150/audio/1"; 
DataSink sink; 
MediaLocator src = new MediaLocator(srcUrl); 

try { 
p = Manager.createPlayer(src); 
p.addControllerListener(this); 
p.start(); 
} catch(Exception e) { 
e.printStackTrace(); 
System.exit(1); 
} 
} 

public synchronized void controllerUpdate(ControllerEvent evt) { 
if (evt instanceof EndOfMediaEvent) { 
System.exit(0); 
} else { 
System.out.println(evt.toString()); 
} 
} 
} 
