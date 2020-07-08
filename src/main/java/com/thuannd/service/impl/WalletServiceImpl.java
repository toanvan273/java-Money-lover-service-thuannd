package com.thuannd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuannd.dao.WalletDAO;
import com.thuannd.entities.Wallet;
import com.thuannd.service.WalletService;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletDAO walletDAO;

	@Override
	public void addWallet(List<Wallet> wallets) {
		List<Wallet> listForRemove = walletDAO.getAllWallet().get();
		listForRemove.forEach(wl -> {
			walletDAO.deleteWallet(wl);
		});
		wallets.forEach(wallet -> {
			this.insertWallet(wallet);
		});
	}

	public void insertWallet(Wallet wallet) {
		walletDAO.addWallet(wallet);
	}

	@Override
	public List<Wallet> getAllWallet() {
		List<Wallet> wallets = walletDAO.getAllWallet().get();
		List<Wallet> expect = new ArrayList<Wallet>();
		wallets.forEach(w ->{
			Wallet wallet = new Wallet();
			wallet.setBalance(w.getBalance());
			wallet.setDesc(w.getDesc());
			wallet.setWalletName(w.getWalletName());
			
			expect.add(wallet);
		});
		return expect;
	}

}
