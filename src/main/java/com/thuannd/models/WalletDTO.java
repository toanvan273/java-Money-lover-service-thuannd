package com.thuannd.models;

import java.io.Serializable;

public class WalletDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String walletName;
	private Double balance;
	private String desc;

	public WalletDTO() {
		super();
	}

	public WalletDTO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
