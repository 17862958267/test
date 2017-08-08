package com.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//hibernate注解orm映射需要的注解都在javax.persisitence包下


//Entity表示交由hibernate管理的实体映射类
@Entity
//表明需要映射到数据库中的表的信息,包含表名称等
//table注解可以省略,如果没有定义table或table中没有定义表名称,则当前默认使用实体名称作为数据库表名称
@Table(name="t_country")
public class Country {

	//hibernate实体必须有id
	@Id
	//注解模式下,主键生成策略默认使用native
	//Table为oracle模式下的sequence策略,可以应用于其他关系型数据库
	//sequence也是oracle模式下的sequence策略,但是只能应用于oracle数据库
	//hibernate注解模式不能提供方便的uuid自动设置功能,必须要手动设置
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	//通过Column的name设置当前属性映射到数据库中的列的名称
	//通过length属性设置该列在数据库中的长度限制
	//通过nullable设置该列是否允许空值,除id以外的其他列默认都是允许空的(建表时自动添加非空约束)
	//通过unique设置该列是否允许定义重复值,建表时自动添加唯一约束
	//
	@Column(name="c_name",length=10,nullable=true,unique=true)
	private String cname;//c_name
	
	private String ccode;//c_code
	
	
	public Country( String cname) {
		this.cname = cname;
	}
	public Country() {
		super();
	}
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ccode=" + ccode + "]";
	}
	
}