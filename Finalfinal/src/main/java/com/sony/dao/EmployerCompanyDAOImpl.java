package com.sony.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.EmployerCompanyEntity;

@Repository
public class EmployerCompanyDAOImpl implements EmployerCompanyDAO {

	private static SessionFactory factory;

	public EmployerCompanyDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addEmployerCompany(EmployerCompanyEntity employercompanyentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employercompanyId = null;

		try {
			tx = session.beginTransaction();
			employercompanyId = (Integer) session.save(employercompanyentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employercompanyId;
	}


}
