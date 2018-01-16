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
@MappedSuperclass  //实体类父类
public class BaseBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;//版本列
	private boolean deleted;//删除位，使用默认配置
	@Temporal(value=TemporalType.TIMESTAMP)//时间戳
	private Date deteCreated;
}
