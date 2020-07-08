package com.thuannd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuannd.entities.Group;
import com.thuannd.service.GroupService;

@RestController
@RequestMapping("/money-lover")
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	@PostMapping("/groups")
	public ResponseEntity<Void> addGroup(@RequestBody List<Group> groups){
		groupService.addGroup(groups);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/groups")
	public ResponseEntity<List<Group>> getAllGroup(){
		return new ResponseEntity<List<Group>>(groupService.getAllGroup(), HttpStatus.OK);
	}
	
}
