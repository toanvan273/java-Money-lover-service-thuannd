package com.thuannd.dao;

import java.util.List;
import java.util.Optional;

import com.thuannd.entities.Wallet;

public interface WalletDAO {
	
	Optional<List<Wallet>> getAllWallet();
	
	Optional<Wallet> getWalletById(int idWallet);

	Optional<Wallet> getWalletByIdWalletLocal(int idLocal);
	
	void addWallet(Wallet wallet);
	
	void deleteWallet(Wallet wallet);
	
}
