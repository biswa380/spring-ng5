package com.biswa.springangular.domains;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role_feature_permission_scheme")
public class RoleFeaturePermissionScheme implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_feature_permission_scheme_id")
	private int roleFeaturePermissionSchemeId;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@ManyToOne
	@JoinColumn(name="role_id_fk", nullable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="feature_permission_id_fk")
	private FeaturePermissionMapping featurePermissionMapping;
	
//	@Column(name="AreaCode")
//	private String areaCode;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@OneToMany(mappedBy="roleFeaturePermissionScheme", fetch=FetchType.EAGER)
	private List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings;
	

	public RoleFeaturePermissionScheme(int roleFeaturePermissionSchemeId2) {
		this.roleFeaturePermissionSchemeId = roleFeaturePermissionSchemeId2;
	}

	public RoleFeaturePermissionScheme() {
	}
	
	public int getRoleFeaturePermissionSchemeId() {
		return roleFeaturePermissionSchemeId;
	}

	public void setRoleFeaturePermissionSchemeId(int roleFeaturePermissionSchemeId) {
		this.roleFeaturePermissionSchemeId = roleFeaturePermissionSchemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public FeaturePermissionMapping getFeaturePermissionMapping() {
		return featurePermissionMapping;
	}

	public void setFeaturePermissionMapping(FeaturePermissionMapping featurePermissionMapping) {
		this.featurePermissionMapping = featurePermissionMapping;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<UserRoleFeaturePermissionMapping> getUserRoleFeaturePermissionMappings() {
		return userRoleFeaturePermissionMappings;
	}

	public void setUserRoleFeaturePermissionMappings(
			List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings) {
		this.userRoleFeaturePermissionMappings = userRoleFeaturePermissionMappings;
	}
	
//	public String getAreaCode() {
//		return areaCode;
//	}
//
//	public void setAreaCode(String areaCode) {
//		this.areaCode = areaCode;
//	}
}
