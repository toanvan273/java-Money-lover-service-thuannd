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

import com.thuannd.dao.WalletDAO;
import com.thuannd.entities.Wallet;

@Repository
@Transactional
public class WalletDAOImpl implements WalletDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<List<Wallet>> getAllWallet() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Wallet> query = builder.createQuery(Wallet.class);
		Root<Wallet> root = query.from(Wallet.class);
		TypedQuery<Wallet> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getResultList());
	}

	@Override
	public Optional<Wallet> getWalletById(int idWallet) {
		return Optional.of(entityManager.find(Wallet.class, idWallet));
	}

	@Override
	public Optional<Wallet> getWalletByIdWalletLocal(int idLocal) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Wallet> query = builder.createQuery(Wallet.class);
		Root<Wallet> root = query.from(Wallet.class);
		query.where(builder.equal(root.get("idWalletLocal"), idLocal));
		TypedQuery<Wallet> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getSingleResult());
	}
	
	@Override
	public void addWallet(Wallet wallet) {
		entityManager.persist(wallet);
	}

	@Override
	public void deleteWallet(Wallet wallet) {
		entityManager.remove(wallet);
	}
	
}
