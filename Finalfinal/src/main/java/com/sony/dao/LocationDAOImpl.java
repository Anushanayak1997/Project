package com.sony.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.LocationEntity;
import com.sony.model.entity.UserEntity;

@Repository
public class LocationDAOImpl implements LocationDAO {

	private static SessionFactory factory;

	public LocationDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addLocation(LocationEntity location) {

		Session session = factory.openSession();
		Transaction tx = null;
		Integer locationid = null;

		try {
			tx = session.beginTransaction();
			locationid = (Integer) session.save(location);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return locationid;

	}

	public List<LocationEntity> getAllLocation() {
		Session session = factory.openSession();
		List<LocationEntity> location = new ArrayList<LocationEntity>();

		try {
			location = session.createQuery("FROM LocationEntity").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return location;
	}

}
