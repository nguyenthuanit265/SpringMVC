package com.myclass.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.repository.GenericRepository;

@Transactional(rollbackOn = Exception.class)
public class GenericRepositoryImpl<T, K extends Serializable> implements GenericRepository<T, K> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<? extends T> clazz;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericRepositoryImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType paraType = (ParameterizedType) type;
		clazz = (Class) paraType.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<T> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = (CriteriaQuery<T>) builder.createQuery(clazz);
			Root<T> root = (Root<T>) query.from(clazz);
			query.select(root);
			Query<T> q = session.createQuery(query);
			List<T> employees = q.getResultList();
			return employees;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void Add(T t) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.saveOrUpdate(t);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void Update(T t) {
		Session session = sessionFactory.getCurrentSession();
		try {

			session.saveOrUpdate(t);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void RemoveById(K id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			T t = FindById(id);
			session.remove(t);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public T FindById(K id) {
		Session session = sessionFactory.getCurrentSession();
		try {

			T t = session.find(clazz, id);
			return t;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
