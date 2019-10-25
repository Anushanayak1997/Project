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

import com.sony.model.entity.CompanyEntity;
import com.sony.model.entity.EmployerCompanyEntity;
import com.sony.model.entity.JobPostEntity;
import com.sony.model.entity.UserEntity;

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

	public Integer addJobPost(JobPostEntity jobpostentity) {
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

	public List<JobPostEntity> getJobsByCompId(CompanyEntity company) {
		Session session = factory.openSession();
		List<JobPostEntity> jobposts = new ArrayList<JobPostEntity>();
		Integer companyId = company.getCompanyId();
	

		try {
			String hql = "FROM JobPostEntity where companyentity.companyId = :companyid";
			Query query = session.createQuery(hql);
			query.setParameter("companyid", companyId);

			List<JobPostEntity> result = query.list();
			if (!result.isEmpty()) {
				// JobPostEntity jpe = (JobPostEntity) result.get(0);
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
