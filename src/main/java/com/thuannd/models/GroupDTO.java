package com.thuannd.models;

import java.io.Serializable;

public class GroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String groupName;
	private String groupImage;
	private int groupType;

	public GroupDTO() {
		super();
	}

	public GroupDTO(Integer id) {
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

}
