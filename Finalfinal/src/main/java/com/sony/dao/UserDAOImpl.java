package com.sony.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
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

	public void addUser(UserEntity userentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userId = null;

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
	}

	public List<UserEntity> getAllUsers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<UserEntity> users  = new ArrayList<UserEntity>();

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
