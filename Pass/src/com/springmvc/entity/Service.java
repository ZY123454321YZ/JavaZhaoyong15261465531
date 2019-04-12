package com.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
/**
 * 
 * @author ZhaoYong
 * 资产管理表
 *
 */
public class Service {
	/**
	 * 服务图标
	 */
	@Column(name = "logoUrl")
	private String logoUrl;
	
	/**
	 * 资产id
	 */
	@Id
	private int astId;
	
	/**
	 * 资产版本
	 */
	@Column(name = "astVer")
	private String astVer;
	
	/**
	 * 服务类型
	 */
	@Column(name = "svrType")
	private String svrType;
	
	/**
	 * 是否提交
	 */
	@Column(name = "isSubmit")
	private int isSubmit;
	
	/**服务类别ID
	 * 
	 */
	@Column(name = "svrCategoryId")
	private int svrCategoryId;
	
	
	/**
	 * 服务描述
	 */
	@Column(name = "svrDescription")
	private String svrDescription;
	
	/**
	 * 规格描述
	 */
	@Column(name = "specDesc")
	private String specDesc;
	
//	系统组ID
	@Column(name = "sysCategoryId")
	private String sysCategoryId;
	
	/**
	 * 服务标签
	 */
	@Column(name = "svrLabels")
	private String svrLabels;
	
	
	/**
	 * 标签名
	 */
	@Column(name = "labelName")
	private String labelName;
	
	/**
	 * 标签值
	 */
	@Column(name = "labelValue")
	private String labelValue;
	
	/**
	 * 标签项
	 */
	@Column(name = "labelCode")
	private String labelCode;

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public int getAstId() {
		return astId;
	}

	public void setAstId(int astId) {
		this.astId = astId;
	}

	public String getAstVer() {
		return astVer;
	}

	public void setAstVer(String astVer) {
		this.astVer = astVer;
	}

	public String getSvrType() {
		return svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	public int getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(int isSubmit) {
		this.isSubmit = isSubmit;
	}

	public int getSvrCategoryId() {
		return svrCategoryId;
	}

	public void setSvrCategoryId(int svrCategoryId) {
		this.svrCategoryId = svrCategoryId;
	}

	public String getSvrDescription() {
		return svrDescription;
	}

	public void setSvrDescription(String svrDescription) {
		this.svrDescription = svrDescription;
	}

	public String getSpecDesc() {
		return specDesc;
	}

	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}

	public String getSysCategoryId() {
		return sysCategoryId;
	}

	public void setSysCategoryId(String sysCategoryId) {
		this.sysCategoryId = sysCategoryId;
	}

	public String getSvrLabels() {
		return svrLabels;
	}

	public void setSvrLabels(String svrLabels) {
		this.svrLabels = svrLabels;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

}
