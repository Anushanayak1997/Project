package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import com.sony.model.entity.JobSeekerEducationType;

@Repository
public class JobSeekerEducationTypeDAOImpl implements JobSeekerEducationTypeDAO{


	private static SessionFactory factory;

	public JobSeekerEducationTypeDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerEducationType(JobSeekerEducationType educationType) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekereducationTypeid = null;

		try {
			tx = session.beginTransaction();
			jobseekereducationTypeid = (Integer) session.save(educationType);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekereducationTypeid;
	}

	public List<JobSeekerEducationType> getAllSeekerEducationType() {
		Session session = factory.openSession();
		List<JobSeekerEducationType> educationType = new ArrayList<JobSeekerEducationType>();

		try {
			educationType= session.createQuery("FROM JobSeekerEducationType").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return educationType;
	}
	
}
