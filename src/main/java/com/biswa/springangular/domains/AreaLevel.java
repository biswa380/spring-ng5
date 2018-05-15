package com.biswa.springangular.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * This Entity class will keep all the area level available in our system
 * @author Subrata Pradhan
 * @since version 1.0.0.0
 *
 */
@Entity
public class AreaLevel implements Serializable{
	
	private static final long serialVersionUID = 1519381375815795764L;

	@Id
	@Column(name = "AreaLevelId")
	private Integer areaLevelId;
	
	@Column(name = "AreaLevelName", nullable = false)
	private String areaLevelName;
	
	
	@OneToMany(mappedBy="areaLevel")
	private List<Area> areas;

	public Integer getAreaLevelId() {
		return areaLevelId;
	}

	public void setAreaLevelId(Integer areaLevelId) {
		this.areaLevelId = areaLevelId;
	}

	public String getAreaLevelName() {
		return areaLevelName;
	}

	public void setAreaLevelName(String areaLevelName) {
		this.areaLevelName = areaLevelName;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public AreaLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AreaLevel(Integer areaLevelId) {
		super();
		this.areaLevelId = areaLevelId;
	}
	
}
