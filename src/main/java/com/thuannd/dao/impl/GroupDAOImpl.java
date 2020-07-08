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

import com.thuannd.dao.GroupDAO;
import com.thuannd.entities.Group;

@Repository
@Transactional
public class GroupDAOImpl implements GroupDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Optional<List<Group>> getAllGroup() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Group> query = builder.createQuery(Group.class);
		Root<Group> root = query.from(Group.class);
		TypedQuery<Group> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getResultList());
	}

	@Override
	public Optional<Group> getGroupById(int idGroup) {
		return Optional.of(entityManager.find(Group.class, idGroup));
	}

	@Override
	public Optional<Group> getGroupByIdGroupLocal(int idLocal) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Group> query = builder.createQuery(Group.class);
		Root<Group> root = query.from(Group.class);
		query.where(builder.equal(root.get("idGroupLocal"), idLocal));
		TypedQuery<Group> typedQuery = entityManager.createQuery(query.select(root));
		return Optional.of(typedQuery.getSingleResult());
	}

	@Override
	public void addGroup(Group group) {
		entityManager.persist(group);
	}

	@Override
	public void deleteGroup(Group group) {
		entityManager.remove(group);
	}
	
}
