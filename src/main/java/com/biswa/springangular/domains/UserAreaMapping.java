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
@Table(name="user_area_mapping")
public class UserAreaMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userAreaMappingId;
	
	@Column(name="created_date", nullable = false)
	private Timestamp createdDate;
	
	@Column(name="is_live")
	private Boolean isLive;
	
//	********  bi-directional many-to-one association to Area *******
	
	@ManyToOne
	@JoinColumn(name="area_id_fk")
	private Area areaId;
	
//	********  bi-directional many-to-one association to User *******
	
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	private UserDetails user;
	
//	********bi-directional one-to-many association to TXNPlanning *******
	
/*	@OneToMany(mappedBy="userAreaMapping")
	private List<TXNPlanning> txnPlannings;*/
	
//	********bi-directional one-to-many association to UserRoleFeaturePermissionMapping *******
	
	/*@OneToMany(mappedBy="userAreaMapping", fetch = FetchType.EAGER)
	private List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings;*/

	//GETTER SETTER **********************
	
	public Integer getUserAreaMappingId() {
		return userAreaMappingId;
	}

	/*public List<UserRoleFeaturePermissionMapping> getUserRoleFeaturePermissionMappings() {
		return userRoleFeaturePermissionMappings;
	}

	public void setUserRoleFeaturePermissionMappings(
			List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings) {
		this.userRoleFeaturePermissionMappings = userRoleFeaturePermissionMappings;
	}*/

/*	public List<TXNPlanning> getTxnPlannings() {
		return txnPlannings;
	}*/

/*	public void setTxnPlannings(List<TXNPlanning> txnPlannings) {
		this.txnPlannings = txnPlannings;
	}*/
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setUserAreaMappingId(Integer userAreaMappingId) {
		this.userAreaMappingId = userAreaMappingId;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Area getAreaId() {
		return areaId;
	}

	public void setAreaId(Area areaId) {
		this.areaId = areaId;
	}

	public Boolean getIsLive() {
		return isLive;
	}

	public void setIsLive(Boolean isLive) {
		this.isLive = isLive;
	}
	
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	
}
