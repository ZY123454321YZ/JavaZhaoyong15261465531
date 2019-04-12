package com.huawei.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperUtil {
	public static void main(String[] args) throws IOException {
		 String hostPort = "192.168.43.107:2181";
		    String zpath = "/";
		    List <String> zooChildren = new ArrayList<String>();
		    ZooKeeper zk = new ZooKeeper(hostPort, 2000, null);
		    if (zk != null) {
		      try {
		        zooChildren = zk.getChildren(zpath, false);
		        System.out.println("Znodes of '/': ");
		        for (String child: zooChildren) {
		          //print the children
		          System.out.println(child);
		        }
		      } catch (KeeperException e) {
		        e.printStackTrace();
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		   }

}
