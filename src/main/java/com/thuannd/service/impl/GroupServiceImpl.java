package com.thuannd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuannd.dao.GroupDAO;
import com.thuannd.entities.Group;
import com.thuannd.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupDAO groupDAO;
	
	@Override
	public void addGroup(List<Group> groups) {
		List<Group> listForRemove = groupDAO.getAllGroup().get();
		listForRemove.forEach(gr ->{
			groupDAO.deleteGroup(gr);
		});
		groups.forEach(gr ->{
			this.insertGroup(gr);
		});
	}
	
	public void insertGroup(Group group) {
		groupDAO.addGroup(group);
	}

	@Override
	public List<Group> getAllGroup() {
		List<Group> groups = groupDAO.getAllGroup().get();
		List<Group> expect = new ArrayList<Group>();
		groups.forEach(gr ->{
			Group group = new Group();
			group.setIdGroupLocal(gr.getIdGroupLocal());
			group.setGroupName(gr.getGroupName());
			group.setGroupType(gr.getGroupType());
			
			expect.add(group);
		});
		return expect;
	}

}
