package com.sony.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sony.controller.CompanyController;
import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.JobSeekerSkills;
import com.sony.model.entity.SkillSet;

@Repository
public class JobSeekerSkillDAOImpl implements JobSeekerSkillDAO {

	private static SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
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

	public List<JobSeekerSkills> getSeekerSkillById(int userId) {
		Session session = factory.openSession();
		List<JobSeekerSkills> result = null;
		try {
			Query query = session.createQuery("from JobSeekerSkills where user.userID = :userId");
			query.setParameter("userId", userId);
			List<JobSeekerSkills> seekerprojects = new ArrayList<JobSeekerSkills>();
			seekerprojects = query.list();
			logger.info("Projects");
			if (seekerprojects != null)
				result = seekerprojects;
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}
	}

	

