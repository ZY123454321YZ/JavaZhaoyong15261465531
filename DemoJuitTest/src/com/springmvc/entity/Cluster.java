package com.springmvc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "cluster")
public class Cluster {
	/**
	 * 集群ID
	 */
	private String clusterId;
	/**
	 * 集群详情ID
	 */
	private int  clusterDetailId;
	/**
	 * 节点标签列表
	 */
	private List<String>cluLabels;
	/**
	 * 集群详情id
	 */
	private int clusterid;
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public int getClusterDetailId() {
		return clusterDetailId;
	}
	public void setClusterDetailId(int clusterDetailId) {
		this.clusterDetailId = clusterDetailId;
	}
	public List<String> getCluLabels() {
		return cluLabels;
	}
	public void setCluLabels(List<String> cluLabels) {
		this.cluLabels = cluLabels;
	}
	public int getClusterid() {
		return clusterid;
	}
	public void setClusterid(int clusterid) {
		this.clusterid = clusterid;
	}
	
	
}
