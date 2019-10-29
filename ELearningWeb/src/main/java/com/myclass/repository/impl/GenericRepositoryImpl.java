package com.myclass.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.repository.GenericRepository;

@Transactional(rollbackOn = Exception.class)
public abstract class GenericRepositoryImpl<T, K extends Serializable> implements GenericRepository<T, K> {
	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<? extends T> clazz;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericRepositoryImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType paraType = (ParameterizedType) type;
		clazz = (Class) paraType.getActualTypeArguments()[0];
	}

	public void SaveOrUpdate(T t) {
		Session session = sessionFactory.getCurrentSession();

		try {

			session.saveOrUpdate(t);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	public List<T> FindAll() {
		Session session = sessionFactory.getCurrentSession();
		List<T> employees = null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = (CriteriaQuery<T>) builder.createQuery(clazz);
			Root<T> root = (Root<T>) query.from(clazz);
			query.select(root);
			Query<T> q = session.createQuery(query);
			employees = q.getResultList();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return employees;
	}

	public T FindById(K id) {
		Session session = sessionFactory.getCurrentSession();
		try {

			return session.find(clazz, id);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	public void RemoveById(K id) {
		Session session = sessionFactory.getCurrentSession();

		try {

			// truy vấn dữ liệu
			T t = FindById(id);
			session.remove(t);

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
