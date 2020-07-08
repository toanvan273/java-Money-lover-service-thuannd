package com.thuannd.service;

import java.util.List;

import com.thuannd.entities.Group;

public interface GroupService {
	
	void addGroup(List<Group> groups);
	
	List<Group> getAllGroup();
	
}
