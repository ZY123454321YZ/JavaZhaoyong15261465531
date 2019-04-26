package com.springmvc.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "harbor")
public class Harbor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int harborId;
	/**
	 * Harbor用户名称
	 */
	@Column(name = "harborUser")
	private String harborUser;
	
	/**
	 * Harbor用户密码
	 */
	@Column(name = "harborPwd")
	private String harborPwd;
	
	@Column(name = "backUrl")
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
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
	public int getHarborId() {
		return harborId;
	}
	public void setHarborId(int harborId) {
		this.harborId = harborId;
	}

}
