package com.myclass.repository.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl extends GenericRepositoryImpl<Role, String> implements RoleRepository {
//	private List<Role> roles = null;
//
//	public RoleRepositoryImpl() {
//		roles = new ArrayList<Role>();
//		roles.add(new Role("611885c8-891b-40fb-b752-e7bc4f6729a9", "ROLE_ADMIN", "Quản trị hệ thống"));
//	}
//
//	public void add(Role role) {
//		roles.add(role);
//
//	}
//
//	public List<Role> FindAll() {
//
//		return roles;
//	}
//
//	public Role FindById(String id) {
//		for (Role role : roles) {
//			if (role.getId().equals(id)) {
//				return role;
//
//			}
//		}
//		return null;
//	}
//
//	public void Update(Role role) {
//		Role model = FindById(role.getId());
//		if (model != null) {
//			model.setName(role.getName());
//			model.setDescription(role.getDescription());
//		}
//
//	}
//
//	public void RemoveById(String id) {
//		Role model = FindById(id);
//		if (model != null) {
//			roles.remove(model);
//		}
//
//	}

//	@Autowired
//	SessionFactory sessionFactory;
//
//	public void SaveOrUpdate(Role role) {
////		Session session = sessionFactory.openSession();
////		Transaction transaction = null;
////
////		try {
////			transaction = session.beginTransaction();
////
////			session.saveOrUpdate(role);
////
////			transaction.commit();
////		} catch (HibernateException e) {
////			// TODO: handle exception
////			transaction.rollback();
////		} finally {
////			session.close();
////		}
//
//		Session session = sessionFactory.getCurrentSession();
//
//		try {
//
//			session.saveOrUpdate(role);
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}
//
//	public Role FindById(String id) {
//		Session session = sessionFactory.getCurrentSession();
//		try {
//
//			return session.find(Role.class, id);
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//		return null;
//	}
//
//	public void RemoveById(String id) {
//		Session session = sessionFactory.getCurrentSession();
//
//		try {
//
//			// truy vấn dữ liệu
//			Role role = FindById(id);
//			session.remove(role);
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//
//	public List<Role> FindAll() {
////		Session session = sessionFactory.openSession();
////		List<Role> roles = null;
////		try {
////			Query<Role> query = session.createQuery("from roles", Role.class);
////			roles = query.getResultList();
////
////		} catch (HibernateException e) {
////			// TODO: handle exception
////			e.printStackTrace();
////		} finally {
////			session.close();
////		}
////
////		return roles;
//
//		Session session = sessionFactory.getCurrentSession();
//		List<Role> roles = null;
//		try {
//			Query<Role> query = session.createQuery("from roles", Role.class);
//			roles = query.getResultList();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return roles;
//	}

}