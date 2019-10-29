package com.myclass.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserRepositoryImpl extends GenericRepositoryImpl<User, String> implements UserRepository {

	@Autowired
	SessionFactory sessionFactory;

//	public void SaveOrUpdate(User user) {
//		Session session = sessionFactory.getCurrentSession();
//		// Transaction transaction = null;
//
//		try {
//			// transaction = session.beginTransaction();
//
//			session.saveOrUpdate(user);
//
//			// transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} /*
//			 * finally { session.close(); }
//			 */
//	}
//
//	public List<User> FindAll() {
//		Session session = sessionFactory.getCurrentSession();
//		List<User> users = null;
//		try {
//			Query<User> query = session.createQuery("from users", User.class);
//			users = query.getResultList();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return users;
//	}
//
//	public User FindById(String id) {
//		Session session = sessionFactory.getCurrentSession();
//		User user = null;
//		try {
//
//			user = session.find(User.class, id);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return user;
//	}
//
//	public void RemoveById(String id) {
//		Session session = sessionFactory.getCurrentSession();
//		// Transaction transaction = null;
//		try {
//			User user = FindById(id);
//			// transaction = session.beginTransaction();
//
//			session.remove(user);
//
//			// transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}

	public void Update(User user) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE users SET email=:email, fullname=:fullname, address=:address, avatar=:avatar, phone=:phone,facebook=:facebook, website=:website, role_id=:role_id WHERE id=:id";

		try {
			Query query = session.createQuery(hql);
			query.setParameter("email", user.getEmail());
			query.setParameter("fullname", user.getFullname());
			query.setParameter("address", user.getAddress());
			query.setParameter("phone", user.getPhone());
			query.setParameter("facebook", user.getFacebook());
			query.setParameter("website", user.getWebsite());
			query.setParameter("avatar", user.getAvatar());
			query.setParameter("role_id", user.getRoleId());
			query.setParameter("id", user.getId());
			query.executeUpdate();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public int updatePassword(ChangePassword changePassword) {
		int result = -1;
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE users SET password=:password WHERE email=:email";

		try {
			Query query = session.createQuery(hql);
			query.setParameter("password", changePassword.getPassword());
			query.setParameter("email", changePassword.getEmail());

			return result = query.executeUpdate();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;

	}

	public User findByEmail(String email) {
		String hql = "FROM users WHERE email = :email";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
