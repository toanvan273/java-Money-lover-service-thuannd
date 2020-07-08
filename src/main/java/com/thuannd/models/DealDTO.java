package com.thuannd.models;

import java.io.Serializable;

public class DealDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long value;
	private Integer walletId;
	private Integer groupId;
	private String createdDate;
	private int userId;
	private String description;
	private int idDealLocal;

//	private GroupDTO groupDTO;
//	private WalletDTO walletDTO;

	public DealDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdDealLocal() {
		return idDealLocal;
	}

	public void setIdDealLocal(int idDealLocal) {
		this.idDealLocal = idDealLocal;
	}

//	public GroupDTO getGroupDTO() {
//		return groupDTO;
//	}
//
//	public void setGroupDTO(GroupDTO groupDTO) {
//		this.groupDTO = groupDTO;
//	}
//
//	public WalletDTO getWalletDTO() {
//		return walletDTO;
//	}
//
//	public void setWalletDTO(WalletDTO walletDTO) {
//		this.walletDTO = walletDTO;
//	}

}
