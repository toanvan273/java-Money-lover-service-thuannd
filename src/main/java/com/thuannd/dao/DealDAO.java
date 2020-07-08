package com.thuannd.dao;

import java.util.List;
import java.util.Optional;

import com.thuannd.entities.Deal;

public interface DealDAO {

void insertBatchDeal(List<Deal> deals);
	
	void addDeal(Deal deal);
	
	Optional<List<Deal>> getDealByUserId(int userId);
	
	void deleteDeal(Deal deal);
	
	Optional<Deal> getDealById(int dealId);
	
	Optional<List<Deal>> getAllDeal();
	
	void editDeal(Deal deal);
	
}
