package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.JobSeekerCourse;

@Repository
public class JobSeekerCourseDAOImpl implements JobSeekerCourseDAO {

	private static SessionFactory factory;

	public JobSeekerCourseDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerCourse(JobSeekerCourse course) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekercourseid = null;

		try {
			tx = session.beginTransaction();
			jobseekercourseid = (Integer) session.save(course);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekercourseid;
	}

	public List<JobSeekerCourse> getAllSeekerCourse() {
		Session session = factory.openSession();
		List<JobSeekerCourse> course = new ArrayList<JobSeekerCourse>();

		try {
			course = session.createQuery("FROM JobSeekerCourse").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return course;
	}

}
