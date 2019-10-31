package com.sony.dao;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


import com.sony.model.entity.Specialisation;

@Repository
public class SpecialisationDAOImpl implements  SpecialisationDAO{

	private static SessionFactory factory;

	public SpecialisationDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	public Integer addSpecialisation(Specialisation Specialisationset) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tx = null;
		Integer specialisationid = null;

		try {
			tx = session.beginTransaction();
			specialisationid = (Integer) session.save(Specialisationset);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return specialisationid;
	
	}

	public List<Specialisation> getAllSpecialisations() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<Specialisation> specialisations = new ArrayList<Specialisation>();

		try {
			specialisations= session.createQuery("FROM Specialisation").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return specialisations;
	}
	}

	

