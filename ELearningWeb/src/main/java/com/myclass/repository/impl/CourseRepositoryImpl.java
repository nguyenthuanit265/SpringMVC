package com.myclass.repository.impl;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;

@Repository
public class CourseRepositoryImpl extends GenericRepositoryImpl<Course, Integer> implements CourseRepository {

//	private List<Course> courses = null;
//
//	public CourseRepositoryImpl() {
//		courses = new ArrayList<Course>();
//		// Course couse = new Course(1, "Javascript", "", 10, 1, 0 , 12000000, 10,
//		// 12000000,"Khóa học Javascript" , "", , lastUpdate)
//
//	}
//	@Autowired
//	SessionFactory sessionFactory;
//
//	public void SaveOrUpdate(Course course) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//		try {
//
//			transaction = session.beginTransaction();
//
//			session.saveOrUpdate(course);
//
//			transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			transaction.rollback();
//		} finally {
//			session.close();
//		}
//	}
//
//	public List<Course> FindAll() {
//		Session session = sessionFactory.openSession();
//		List<Course> courses = null;
//		try {
//
//			Query<Course> query = session.createQuery("from courses", Course.class);
//			courses = query.getResultList();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return courses;
//	}
//
//	public Course FindById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//		Course course = null;
//		try {
//			transaction = session.beginTransaction();
//			course = session.find(Course.class, id);
//
//			transaction.commit();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			session.close();
//
//		}
//		return course;
//	}
//
//	public void RemoveById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//
//		try {
//			transaction = session.beginTransaction();
//			Course course = FindById(id);
//			session.remove(course);
//			transaction.commit();
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			transaction.rollback();
//			// TODO: handle exception
//		} finally {
//			session.close();
//		}
//
//	}

}
