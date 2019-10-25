package com.sony.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobSeekerSkills;
import com.sony.model.entity.SkillSet;

@Repository
public class JobSeekerSkillDAOImpl implements JobSeekerSkillDAO {

	private static SessionFactory factory;

	public JobSeekerSkillDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerSkill(JobSeekerSkills skill) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerskillid = null;

		try {
			tx = session.beginTransaction();
			jobseekerskillid = (Integer) session.save(skill);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekerskillid;
	}

	public List<JobSeekerSkills> getAllSkills() {
		Session session = factory.openSession();
		List<JobSeekerSkills> skills = new ArrayList<JobSeekerSkills>();

		try {
			skills= session.createQuery("FROM JobSeekerSkills").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return skills;
	}

}
