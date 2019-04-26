package com.springmvc.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "cluster")
public class Cluster {
	
	/**
	 * 集群详情id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clusterid;
	/**
	 * 集群详情ID
	 */
	@Column(name = "clusterDetailId")
	private int  clusterDetailId;
	/**
	 * 节点标签列表
	 */
	@Column(name = "cluLabels")
	private String  cluLabels;

	public String getCluLabels() {
		return cluLabels;
	}
	public void setCluLabels(String cluLabels) {
		this.cluLabels = cluLabels;
	}
	public int getClusterDetailId() {
		return clusterDetailId;
	}
	public void setClusterDetailId(int clusterDetailId) {
		this.clusterDetailId = clusterDetailId;
	}
	public int getClusterid() {
		return clusterid;
	}
	public void setClusterid(int clusterid) {
		this.clusterid = clusterid;
	}
	
	
}
