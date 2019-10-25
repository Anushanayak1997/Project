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

	public Integer addEmployerCompany(EmployerCompany employercompanyentity) {
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

	public Integer getCompanyId(Integer UserId) {
		Session session = factory.openSession();
		Integer companyId = null;
		List<EmployerCompany> companies = new ArrayList<EmployerCompany>();

		try {
			Query query = session.createQuery("from EmployerCompany where userId='" + UserId + "'");
			EmployerCompany employercompany = (EmployerCompany) query.uniqueResult();
			if (employercompany != null)
				companyId = employercompany.getCompanyId();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return companyId;
	}
}
