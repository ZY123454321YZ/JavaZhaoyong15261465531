package com.springmvc.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "harbor")
public class Harbor {
	/**
	 * Harbor用户名称
	 */
	@Column(name = "logoUrl")
	private String harborUser;
	/**
	 * Harbor用户密码
	 */
	@Column(name = "logoUrl")
	private String harborPwd;
	/**
	 * 项目名称
	 */
	@Column(name = "logoUrl")
	private String project;
	/**
	 * 回调通知地址
	 */
	@Column(name = "logoUrl")
	private String backUrl;
	public String getHarborUser() {
		return harborUser;
	}
	public void setHarborUser(String harborUser) {
		this.harborUser = harborUser;
	}
	public String getHarborPwd() {
		return harborPwd;
	}
	public void setHarborPwd(String harborPwd) {
		this.harborPwd = harborPwd;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

}
