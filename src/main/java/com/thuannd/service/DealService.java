package com.thuannd.service;

import java.util.List;

import com.thuannd.entities.Deal;
import com.thuannd.models.DealDTO;

public interface DealService {
	
	void insertBatchDeal(List<DealDTO> dealDTOs);

	void addDeal(DealDTO dealDTO);

	List<DealDTO> getDealByUserId(int userId);

	void deleteBatch(List<Deal> deals);

	Deal getDealById(int dealId);

	void deleteDeal(int dealId);

	List<Deal> getAllDeal();

	void editDeal(Deal deal);
}
