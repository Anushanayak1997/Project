package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobPostEntity;
import com.sony.model.entity.UserEntity;

@Repository
public class JobPostDAOImpl implements JobPostDAO {

	private static SessionFactory factory;

	public JobPostDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
  
	public boolean addJobPost(JobPostEntity jobpostentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobpostId ;
		try {
			tx = session.beginTransaction();
			jobpostId = (Integer) session.save(jobpostentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;

	}

	public List<JobPostEntity> getAllJobs() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<JobPostEntity> jobs = new ArrayList<JobPostEntity>();

		try {
			tx = session.beginTransaction();
			jobs = session.createQuery("FROM JobPostEntity").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobs;

	}

}
