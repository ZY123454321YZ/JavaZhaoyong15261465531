package com.springmvc.test;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.extensions.*;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.*;
import org.apache.log4j.Logger;
 
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class Fabric8KubeUtils  {
	public static void main(String[] args) {
		Config config = new ConfigBuilder().withMasterUrl("http://172.32.150.81:8080/").build();
		
	}
 
}
