package com.sony.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.SeekerJobPostStatus;

@Repository
public class SeekerJobPostDAOImpl implements SeekerJobPostDAO {
	
	private static SessionFactory factory;

	public SeekerJobPostDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addSeekerJobPost(SeekerJobPostStatus seekerjobpost) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer seekerjobpostId = null;

		try {
			tx = session.beginTransaction();
			seekerjobpostId = (Integer) session.save(seekerjobpost);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return seekerjobpostId;
	}
	
	public Integer updateStatus(int userId, int jobpostId) {
		return null;
	}

}
