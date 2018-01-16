package com.entity;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.crypto.Data;
@MappedSuperclass  //ʵ���ุ��
public class BaseBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;//�汾��
	private boolean deleted;//ɾ��λ��ʹ��Ĭ������
	@Temporal(value=TemporalType.TIMESTAMP)//ʱ���
	private Date deteCreated;
}
