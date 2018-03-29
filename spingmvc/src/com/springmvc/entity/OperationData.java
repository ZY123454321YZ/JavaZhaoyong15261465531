package com.springmvc.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ZhaoYong ��Ӫ����ͳ�Ʊ�
 *
 */
@Entity
@Table(name = "operationdata")
public class OperationData {
	// ����
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String date;
	// �����û���
	private String countUser;
	// ����ʱ��
	private String countDate;
	// ��½ʱ��
	private String startDate;
	// ע��ʱ��
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
