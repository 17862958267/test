package com.oracle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_province")
public class Province{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String pname;
	
	private String pcode;
	
	//一对多,多对一(一对一),多对多
	//常见使用多对一,并且多对一一般都关闭懒加载
	
	//使用ManyToOne定义多对一关联关系
	//通过targetEntity指定关联的数据类型,可以省略
	//cascade设置级联操作
	//fetch设置是否懒加载
	//使用多对一,如果不为其设置JoinColumn,
	//则使用当前 属性名_(关联目标)主键名作为关联列的列名
	@ManyToOne(
			//targetEntity=Country.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Country country;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Province() {
		
	}
	public Province(String pname, String pcode) {
		this();
		this.pname = pname;
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", pname=" + pname + ", pcode=" + pcode + "]";
	}
}
