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
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.JobSeekerProject;

@Repository
public class JobSeekerProjectDAOImpl implements JobSeekerProjectDAO {

	private static SessionFactory factory;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	public JobSeekerProjectDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public Integer addJobSeekerProject(JobSeekerProject project) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerprojectid = null;

		try {
			tx = session.beginTransaction();
			jobseekerprojectid = (Integer) session.save(project);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekerprojectid;
	}

	public List<JobSeekerProject> getAllProject() {
		Session session = factory.openSession();
		List<JobSeekerProject> project = new ArrayList<JobSeekerProject>();
 
		try {
			project= session.createQuery("FROM JobSeekerProject").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return project;
	}
	
	public List<JobSeekerProject> getProjectsById(int userId) {
		Session session = factory.openSession();
		List<JobSeekerProject> result = null;
		try {
			Query query = session.createQuery("from JobSeekerProject where user.userID = :userId");
			query.setParameter("userId", userId);
			List<JobSeekerProject> seekerprojects = new ArrayList<JobSeekerProject>();
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
