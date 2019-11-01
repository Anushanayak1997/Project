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
import com.sony.model.entity.Company;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.User;


@Repository
public class JobSeekerEducationDAOImpl implements JobSeekerEducationDAO {
 
	private static SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

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

	public List<JobSeekerEducation> getSeekerEducationById(int userId) {
		Session session = factory.openSession();
		List<JobSeekerEducation> result = null;
		try {
			Query query = session.createQuery("from JobSeekerEducation where user.userID = :userId");
			query.setParameter("userId", userId);
			List<JobSeekerEducation> education = new ArrayList<JobSeekerEducation>();
			logger.info("Education" + education);
			education = query.list();
			if (education != null)
				result = education;
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}
}
