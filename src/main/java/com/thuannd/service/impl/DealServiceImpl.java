package com.thuannd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuannd.dao.DealDAO;
import com.thuannd.dao.GroupDAO;
import com.thuannd.dao.WalletDAO;
import com.thuannd.entities.Deal;
import com.thuannd.entities.Group;
import com.thuannd.entities.Wallet;
import com.thuannd.models.DealDTO;
import com.thuannd.service.DealService;

@Service
@Transactional
public class DealServiceImpl implements DealService {

	@Autowired
	private DealDAO dealDAO;

	@Autowired
	private GroupDAO groupDAO;

	@Autowired
	private WalletDAO walletDAO;

	@Override
	public void insertBatchDeal(List<DealDTO> dealDTOs) {
		dealDTOs.forEach(dto -> {
			this.addDeal(dto);
		});
	}

	@Override
	public void addDeal(DealDTO dealDTO) {
		Deal deal = new Deal();
		deal.setValue(dealDTO.getValue());
		deal.setDescription(dealDTO.getDescription());
		deal.setUserID(dealDTO.getUserId());
		deal.setCreatedDate(dealDTO.getCreatedDate());
		
//		Group group = new Group();
//		group.setIdGroupLocal(dealDTO.getGroupDTO().getId());
//		group.setGroupName(dealDTO.getGroupDTO().getGroupName());
//		group.setGroupType(dealDTO.getGroupDTO().getGroupType());
//		deal.setGroup(group);
//		
//		Wallet wallet = new Wallet();
//		wallet.setIdWalletLocal(dealDTO.getWalletDTO().getId());
//		wallet.setBalance(dealDTO.getWalletDTO().getBalance());
//		wallet.setDesc(dealDTO.getWalletDTO().getDesc());
//		wallet.setWalletName(dealDTO.getWalletDTO().getWalletName());
//		deal.setWallet(wallet);
		
		deal.setGroup(groupDAO.getGroupByIdGroupLocal(dealDTO.getGroupId()).get());
		deal.setWallet(walletDAO.getWalletByIdWalletLocal(dealDTO.getWalletId()).get());

		dealDAO.addDeal(deal);
		dealDTO.setId(deal.getId());
	}

	@Override
	public List<DealDTO> getDealByUserId(int userId) {
//		List<Deal> deals = dealDAO.getDealByUserId(userId).get();
//		List<Deal> expect = new ArrayList<Deal>();
//		deals.forEach(d -> {
//			Deal deal = new Deal();
//			deal.setCreatedDate(d.getCreatedDate());
//			deal.setDescription(d.getDescription());
//			deal.setGroup(d.getGroup());
//			deal.setWallet(d.getWallet());
//			deal.setUserID(d.getUserID());
//			deal.setValue(d.getValue());
//
//			expect.add(deal);
//		});
//		return expect;
		List<Deal> deals = dealDAO.getDealByUserId(userId).get();
		List<DealDTO> dealDTOs = new ArrayList<DealDTO>();
		deals.forEach(d -> {
			DealDTO dealDTO = new DealDTO();

			dealDTO.setCreatedDate(d.getCreatedDate());
			dealDTO.setDescription(d.getDescription());
			dealDTO.setWalletId(d.getWallet().getIdWalletLocal());
			dealDTO.setGroupId(d.getGroup().getIdGroupLocal());
			dealDTO.setUserId(d.getUserID());
			dealDTO.setValue(d.getValue());

			dealDTOs.add(dealDTO);
		});
		return dealDTOs;
	}

	@Override
	public void deleteBatch(List<Deal> deals) {

	}

	@Override
	public Deal getDealById(int dealId) {
		return dealDAO.getDealById(dealId).get();
	}

	@Override
	public void deleteDeal(int dealId) {
		Deal deal = this.getDealById(dealId);
		if (deal != null) {
			dealDAO.deleteDeal(deal);
		}
	}

	@Override
	public List<Deal> getAllDeal() {
		return dealDAO.getAllDeal().get();
	}

	@Override
	public void editDeal(Deal deal) {
		dealDAO.editDeal(deal);
	}

}
