package com.oracle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_country")
public class Country {

	@Id
	@GeneratedValue
	private Integer cid;
	
	private String cname;
	
	private String ccode;
	

	
	
	
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