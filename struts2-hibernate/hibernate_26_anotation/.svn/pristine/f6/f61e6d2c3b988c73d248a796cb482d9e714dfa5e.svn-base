package com.oracle.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String username;
	
	
	//使用ManyToMany定义多对多关联映射
	//通过设置cascade设置级联操作
	//通过设置fetch设置懒加载
	@ManyToMany(
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	//默认情况下,关联表使用两个表的完整名称,并以下划线分割
	//通过设置JoinTable来设置关联表的信息
	//设置JoinTable的name值,可以改变关联表的名称
	//设置joinColumn属性,来设置主表关联的列信息(主要为了设置列名)
	//设置inverseJoinColumn属性设置反向实体的列信息
	@JoinTable(
			name="t_user_role",
			
			joinColumns=@JoinColumn(name="user_id"),
			
			inverseJoinColumns=@JoinColumn(name="role_id"))
	
	private Set<Role> roleSet;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String username) {
		super();
		this.name = name;
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + "]";
	}
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
}
