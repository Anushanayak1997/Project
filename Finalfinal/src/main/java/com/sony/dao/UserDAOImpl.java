package com.sony.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sony.model.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	private static SessionFactory factory;

	public UserDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public boolean addUser(UserEntity userentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userId = null; 
		
		if(isUserExists(userentity)) return false;

		try {
			tx = session.beginTransaction();
			userId = (Integer) session.save(userentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isUserExists(UserEntity userentity) {
		Session session = factory.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from UserEntity where emailID='" + userentity.getEmailID() + "'");
			UserEntity u = (UserEntity) query.uniqueResult();
			tx.commit();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public List<UserEntity> getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<UserEntity> users = new ArrayList<UserEntity>();

		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM UserEntity").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

}
