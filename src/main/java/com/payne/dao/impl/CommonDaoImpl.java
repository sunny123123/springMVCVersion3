package com.payne.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payne.dao.ICommonDAO;
@Repository
public class CommonDaoImpl implements ICommonDAO{
	@PersistenceContext  
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	public Object get(Class clazz, Serializable id) {
		return entityManager.find(clazz, id);
	}

	@Override
	@Transactional
	public Serializable add(Object o) {
		entityManager.persist(o);
		return null;
	}

	@Override
	@Transactional
	public void del(Class clazz, Serializable id) {
		Object o = this.entityManager.find(clazz, id);
		entityManager.remove(o);
		
	}

	@Override
	@Transactional
	public void update(Object o) {
		entityManager.refresh(o);
	}

	@Override
	@Transactional(readOnly=true)
	public List list(String hql) {
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public List list(String hql, Object[] args) {
		Query query = entityManager.createQuery(hql);
		for(int i=0;i<args.length;i++)
			query.setParameter(i, args[i]);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryPage(String hql, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryPage(String hql, int page, int pagesize,
			Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}
}
