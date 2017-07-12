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
	private String account;//�˺�
	private String password;//����
	private String sex;//�Ա�
	private String name;//����
	private String birthday;//����
	private String ipCreated;//ע��ʱ��ip��ַ
	
	@Temporal(value=TemporalType.TIMESTAMP)//ʱ���
	private Date dateLastActived;
	
	private String ipLastActived;//���һ�ε�¼��ip
	
	@ManyToMany(mappedBy="administrators") //��Զ�����
	private Set<Board>boardsAdministrated=new HashSet<Board>();//����İ���

}
