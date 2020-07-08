package com.thuannd.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.thuannd.dao.DealDAO;
import com.thuannd.entities.Deal;

@Repository
@Transactional
public class DealDAOImpl implements DealDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertBatchDeal(List<Deal> deals) {
		// to do something
	}

	@Override
	public void addDeal(Deal deal) {
		entityManager.persist(deal);
	}

	@Override
	public Optional<List<Deal>> getDealByUserId(int userId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Deal> query = builder.createQuery(Deal.class);
		Root<Deal> root = query.from(Deal.class);
		query.where(builder.equal(root.get("userID"), userId));
		TypedQuery<Deal> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getResultList());
	}

	@Override
	public void deleteDeal(Deal deal) {
		entityManager.remove(deal);
	}

	@Override
	public Optional<Deal> getDealById(int dealId) {
		return Optional.of(entityManager.find(Deal.class, dealId));
	}

	@Override
	public Optional<List<Deal>> getAllDeal() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Deal> query = builder.createQuery(Deal.class);
		Root<Deal> root = query.from(Deal.class);
		TypedQuery<Deal> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getResultList());
	}

	@Override
	public void editDeal(Deal deal) {
		entityManager.merge(deal);
	}

	
}
