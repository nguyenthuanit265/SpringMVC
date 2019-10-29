package com.myclass.repository.impl;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;

@Repository
public class VideoRepositoryImpl extends GenericRepositoryImpl<Video, Integer> implements VideoRepository {
//	@Autowired
//	SessionFactory sessionFactory;
//
//	public void SaveOrUpdate(Video video) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//
//		try {
//			transaction = session.beginTransaction();
//			session.saveOrUpdate(video);
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
//
//	public List<Video> FindAll() {
//		Session session = sessionFactory.openSession();
//
//		List<Video> videos = null;
//		try {
//
//			Query<Video> query = session.createQuery("from videos", Video.class);
//			videos = query.getResultList();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//
//		return videos;
//
//	}
//
//	public Video FindById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//		Video video = new Video();
//		try {
//			transaction = session.beginTransaction();
//			video = session.find(Video.class, id);
//			transaction.commit();
//
//		} catch (HibernateException e) {
//			// TODO: handle exception
//			transaction.rollback();
//		} finally {
//			session.close();
//		}
//
//		return video;
//
//	}
//
//	public void RemoveById(int id) {
//		Session session = sessionFactory.openSession();
//		Transaction transaction = null;
//
//		try {
//			transaction = session.beginTransaction();
//			Video video = FindById(id);
//			session.remove(video);
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
