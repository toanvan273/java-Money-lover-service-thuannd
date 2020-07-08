package com.thuannd.service;

import java.util.List;

import com.thuannd.entities.Wallet;

public interface WalletService {
	
	void addWallet(List<Wallet> wallets);
	
	List<Wallet> getAllWallet();
	
}
