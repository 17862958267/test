package com.oracle.entity;

import java.util.Set;

//JPA
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="t_role")

//Cache注解放在类上表示类缓存,放在集合上表示集合缓存
//使用Cache应当先开启hibernate二级缓存后再使用
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Role {

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_code")
	private String roleCode;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="t_user_role",
				//joinColumn设置当前表与关联表的关系列
				joinColumns=@JoinColumn(name="role_id"),
				//inverseJoinColumn设置另一方与关联表(中间表)的关系列
				inverseJoinColumns=@JoinColumn(name="user_id")
			)
	
	
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	private Set<User> userSet;
	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + "]";
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName, String roleCode) {
		super();
		this.roleName = roleName;
		this.roleCode = roleCode;
	}
	
}
