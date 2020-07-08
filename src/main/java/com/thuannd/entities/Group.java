package com.thuannd.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_deal")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "group_name")
	private String groupName;
	@Column(name = "group_image")
	private String groupImage;
	@Column(name = "group_type")
	private int groupType;
	@Column(name = "id_group_local")
	private int idGroupLocal;
	
	public Group() {
		super();
	}
	
	public Group(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupImage() {
		return groupImage;
	}

	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
	}

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

	public int getIdGroupLocal() {
		return idGroupLocal;
	}

	public void setIdGroupLocal(int idGroupLocal) {
		this.idGroupLocal = idGroupLocal;
	}

}

