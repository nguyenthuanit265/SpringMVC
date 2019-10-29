package com.myclass.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myclass.repository.CrudRepository;

@Transactional(rollbackFor = Exception.class)
public abstract class CrudRepositoryImpl<T, K extends Serializable> 
	implements CrudRepository<T, K>{

	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<? extends T> clazz;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CrudRepositoryImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) type;
		clazz = (Class) paramType.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = (CriteriaQuery<T>)builder.createQuery(clazz);
			Root<T> root = (Root<T>)query.from(clazz);
			query.select(root);
			Query<T> q = session.createQuery(query);
			return q.getResultList();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public T findById(K id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Truy vấn dữ liệu
			return session.find(clazz, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Truy vấn dữ liệu
			session.saveOrUpdate(entity);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void removeById(K id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Truy vấn dữ liệu
			T entity = findById(id);
			session.remove(entity);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
