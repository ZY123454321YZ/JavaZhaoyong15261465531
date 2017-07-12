package com.entity;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table
public class Board extends BaseBean{
	@ManyToOne      //多对一
	@JoinColumn(name="category_id")//外键列
	private Category category;
	
	
	private String name;   //版面标题
	private String description; //版面描述
	private int threadCount; //帖子总数
	private int replyCount;  //回贴总数
	
	
	@ManyToOne   //多对一
	@JoinColumn(name="last_thread_id")  //外键列
	private Thread lastThread; //最后发表的回帖
	
	@ManyToMany(cascade=CascadeType.ALL)
	@

}
