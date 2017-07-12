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
	@ManyToOne      //���һ
	@JoinColumn(name="category_id")//�����
	private Category category;
	
	
	private String name;   //�������
	private String description; //��������
	private int threadCount; //��������
	private int replyCount;  //��������
	
	
	@ManyToOne   //���һ
	@JoinColumn(name="last_thread_id")  //�����
	private Thread lastThread; //��󷢱�Ļ���
	
	@ManyToMany(cascade=CascadeType.ALL)
	@

}
