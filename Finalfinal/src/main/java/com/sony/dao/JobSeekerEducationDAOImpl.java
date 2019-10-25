package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.JobSeekerExperience;

@Repository
public class JobSeekerEducationDAOImpl implements JobSeekerEducationDAO {
 
	private static SessionFactory factory;

	public JobSeekerEducationDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerEducation(JobSeekerEducation education) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekereducationid = null;

		try {
			tx = session.beginTransaction();
			jobseekereducationid = (Integer) session.save(education);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekereducationid;
	}

	public List<JobSeekerEducation> getAllSeekerEducation() {
		Session session = factory.openSession();
		List<JobSeekerEducation> education = new ArrayList<JobSeekerEducation>();

		try {
			education= session.createQuery("FROM JobSeekerEducation").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return education;
	}

}
