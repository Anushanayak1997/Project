package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.JobSeekerSkills;

@Repository
public class JobSeekerProjectDAOImpl implements JobSeekerProjectDAO {
	private static SessionFactory factory;

	public JobSeekerProjectDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerProject(JobSeekerProject jobseekerproject) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerprojectid = null;

		try {
			tx = session.beginTransaction();
			jobseekerprojectid = (Integer) session.save(jobseekerproject);
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
		List<JobSeekerProject> projects = new ArrayList<JobSeekerProject>();

		try {
			projects= session.createQuery("FROM JobSeekerProject").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return projects;
	}

}
