package com.sony.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.CompanyEntity;
import com.sony.model.entity.UserEntity;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	private static SessionFactory factory;

	public CompanyDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addCompany(CompanyEntity companyentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer companyId = null;

		try {
			tx = session.beginTransaction();
			companyId = (Integer) session.save(companyentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return companyId;
	}

	public List<CompanyEntity> getAllCompany() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<CompanyEntity> companies = new ArrayList<CompanyEntity>();

		try {
			tx = session.beginTransaction();
			companies = session.createQuery("FROM CompanyEntity").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return companies;
	}

}
