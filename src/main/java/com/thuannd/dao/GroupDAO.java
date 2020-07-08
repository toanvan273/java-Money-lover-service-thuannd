package com.thuannd.dao;

import java.util.List;
import java.util.Optional;

import com.thuannd.entities.Group;

public interface GroupDAO {
	Optional<List<Group>> getAllGroup();
	
	Optional<Group> getGroupById(int idGroup);
	
	Optional<Group> getGroupByIdGroupLocal(int idLocal);
	
	void addGroup(Group group);
	
	void deleteGroup(Group group);
	
}
