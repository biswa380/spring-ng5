package com.biswa.springangular.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    String name;
    
    @OneToMany(mappedBy = "role", fetch=FetchType.EAGER)
	private List<RoleFeaturePermissionScheme> roleFeaturePermissionSchemes;
    
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
	
	
	public List<RoleFeaturePermissionScheme> getRoleFeaturePermissionSchemes() {
		return roleFeaturePermissionSchemes;
	}
	public void setRoleFeaturePermissionSchemes(
			List<RoleFeaturePermissionScheme> roleFeaturePermissionSchemes) {
		this.roleFeaturePermissionSchemes = roleFeaturePermissionSchemes;
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public Role() {
	}
	
	
    
    
}
