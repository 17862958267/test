package com.oracle.entity;

public class Country {

	private Integer cid;
	private String cname;
	private Integer versionId;
	
	
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
	public Country() {
		super();
	}
	public Country(String cname) {
		super();
		this.cname = cname;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	
}
