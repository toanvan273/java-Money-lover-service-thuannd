package com.thuannd.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class Deal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "value")
	private Long value;
	@ManyToOne
	@JoinColumn(name = "id_wallet")
	private Wallet wallet;
	@ManyToOne
	@JoinColumn(name = "id_group")
	private Group group;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "id_user")
	private int userID;
	@Column(name = "description")
	private String description;
	@Column(name = "id_deal_local")
	private int idDealLocal;
	
	public Deal() {
		super();
	}

	public Deal(Integer id) {
		this.id = id;
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

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
	
}

