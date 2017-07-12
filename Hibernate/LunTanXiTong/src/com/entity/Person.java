package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table
public class Person extends BaseBean{
	private String account;//账号
	private String password;//密码
	private String sex;//性别
	private String name;//姓名
	private String birthday;//生日
	private String ipCreated;//注册时的ip地址
	
	@Temporal(value=TemporalType.TIMESTAMP)//时间戳
	private Date dateLastActived;
	
	private String ipLastActived;//最后一次登录的ip
	
	@ManyToMany(mappedBy="administrators") //多对多属性
	private Set<Board>boardsAdministrated=new HashSet<Board>();//管理的版面

}
