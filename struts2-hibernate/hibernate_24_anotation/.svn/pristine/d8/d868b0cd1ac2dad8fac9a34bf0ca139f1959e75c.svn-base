package com.oracle.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_country")
public class Country {

	@Id
	@GeneratedValue
	private Integer cid;
	
	private String cname;
	
	private String ccode;
	

	//one2many定义一对多关系
	//targetEntity来定义多放的类型,可以省略
	//cascade为级联操作,与配置文件稍有不同,通常使用All
	//fetch为fetch和lazy整合的结果,设置是否使用延迟加载,如果关闭延迟加载,hibernate会根据具体情况为其指定查询策略
	@OneToMany(
			//targetEntity=Province.class,
			cascade={CascadeType.ALL},
			fetch=FetchType.LAZY
			)
	//必须使用JoinColumn来将关联整合到现有的表中
	//如果不设置该注解,则会形成一个"多对多"的关联关系
	//通常JoinColumn只需要设置列名称即可
	@JoinColumn(name="country_id")
	private Set<Province> provinceSet;
	
	
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
	
	public Set<Province> getProvinceSet() {
		return provinceSet;
	}
	public void setProvinceSet(Set<Province> provinceSet) {
		this.provinceSet = provinceSet;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ccode=" + ccode + "]";
	}
	
}