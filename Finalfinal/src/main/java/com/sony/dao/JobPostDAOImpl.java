package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.Company;
import com.sony.model.entity.EmployerCompany;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.User;

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

	public Integer addJobPost(JobPost jobpostentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobpostId = null;

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
		return jobpostId;

	}

	public List<JobPost> getJobsByCompId(Company company) {
		Session session = factory.openSession();
		List<JobPost> jobposts = new ArrayList<JobPost>();
		Integer companyId = company.getCompanyId();

		try {
			String hql = "FROM JobPost where companyentity.companyId = :companyid";
			Query query = session.createQuery(hql);
			query.setParameter("companyid", companyId);

			List<JobPost> result = query.list();
			if (!result.isEmpty()) {
				jobposts.addAll(result);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobposts;
	}

	public JobPost getJobById(Integer jobpostid) {
		Session session = factory.openSession();
		JobPost jobpost = new JobPost();

		try {
			String hql = "FROM JobPost where jobPostId = :jobpostid";
			Query query = session.createQuery(hql);
			query.setParameter("jobpostid", jobpostid);
			JobPost job = (JobPost) query.uniqueResult();
			if(job != null) {
				jobpost = job;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobpost;
	}

	public List<JobPost> getAllJobs() {
		Session session = factory.openSession();
		List<JobPost> jobposts = new ArrayList<JobPost>();
		try {
			String hql = "FROM JobPost";
			Query query = session.createQuery(hql);
			List<JobPost> result = query.list();
			if (!result.isEmpty()) {
				jobposts.addAll(result);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobposts;
	}

}
