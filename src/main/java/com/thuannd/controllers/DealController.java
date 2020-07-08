package com.thuannd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuannd.entities.Deal;
import com.thuannd.models.DealDTO;
import com.thuannd.service.DealService;

@RestController
@RequestMapping("/money-lover")
public class DealController {

	@Autowired
	private DealService dealService;
	
	@PostMapping("/deals")
	public ResponseEntity<Void> addBatchDeal(@RequestBody List<DealDTO> dealDTOs){
		dealService.insertBatchDeal(dealDTOs);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/deals/{userId}")
	public ResponseEntity<List<DealDTO>> getAllDealByUserId(@PathVariable("userId") int userId){
		return new ResponseEntity<List<DealDTO>>(dealService.getDealByUserId(userId), HttpStatus.OK);
	}
	
}
