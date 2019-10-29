package com.myclass.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User, String> implements UserRepository{

	public User findByEmail(String email) {
		String hql = "FROM users WHERE email = :email";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
