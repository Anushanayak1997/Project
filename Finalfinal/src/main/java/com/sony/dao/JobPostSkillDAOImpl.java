package com.sony.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobPostSkill;

@Repository
public class JobPostSkillDAOImpl implements JobPostSkillDAO {
	
	private static SessionFactory factory;

	public JobPostSkillDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSkill(JobPostSkill jobpostskill) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobpostskillId = null;

		try {
			tx = session.beginTransaction();
			jobpostskillId = (Integer) session.save(jobpostskill);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobpostskillId;
	}

}
