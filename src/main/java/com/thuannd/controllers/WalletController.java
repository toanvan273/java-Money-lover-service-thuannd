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

import com.thuannd.entities.Wallet;
import com.thuannd.service.WalletService;

@RestController
@RequestMapping("/money-lover")
public class WalletController {

	@Autowired
	private WalletService walletService;

	@PostMapping("/wallets")
	public ResponseEntity<Void> addWallet(@RequestBody List<Wallet> wallets) {
		walletService.addWallet(wallets);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/wallets")
	public ResponseEntity<List<Wallet>> getAllWallet(){
		return new ResponseEntity<List<Wallet>>(walletService.getAllWallet(), HttpStatus.OK);
	}
	
}
