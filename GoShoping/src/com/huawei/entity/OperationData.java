package com.huawei.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ZhaoYong 运营数据统计表
 *
 */
@Entity
@Table(name = "operationdata")
public class OperationData {
	// 日期
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String date;
	// 在线用户数
	private String countUser;
	// 在线时长
	private String countDate;
	// 登陆时间
	private String startDate;
	// 注销时间
	private String endDate;

	public String getCountUser() {
		return countUser;
	}

	public void setCountUser(String countUser) {
		this.countUser = countUser;
	}

	public String getCountDate() {
		return countDate;
	}

	public void setCountDate(String countDate) {
		this.countDate = countDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
