package com.oracle.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_province")
public class Province{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String pname;
	
	private String pcode;
	
	
	
	
	
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
