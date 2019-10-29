package com.myclass.repository.impl;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl extends GenericRepositoryImpl<Category, Integer> implements CategoryRepository {
//	private List<Category> categories = null;
//
//	public CategoryRepositoryImpl() {
//		categories = new ArrayList<Category>();
//		Category category = new Category(1, "Developer", "", 1);
//		categories.add(category);
//	}

//	@Autowired
//	SessionFactory sessionFactory;
//
//	public void SaveOrUpdate(Category category) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//
//		try {
//			transaction = session.beginTransaction();
//
//			session.saveOrUpdate(category);
//
//			transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
//
//	public List<Category> FindAll() {
//		Session session = sessionFactory.openSession();
//
//		List<Category> categories = null;
//
//		try {
//
//			Query<Category> query = session.createQuery("from categories", Category.class);
//
//			categories = query.getResultList();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//		return categories;
//
//	}
//
//	public Category FindById(int id) {
//		Category category = null;
//		Session session = sessionFactory.openSession();
//
//		try {
//
//			category = session.find(Category.class, id);
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//		return category;
//	}
//
//	public void RemoveById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//
//		try {
//
//			transaction = session.beginTransaction();
//
//			Category category = FindById(id);
//			session.remove(category);
//
//			transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			transaction.rollback();
//		} finally {
//			session.close();
//		}
//
//	}

}
