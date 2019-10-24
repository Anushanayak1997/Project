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
import org.springframework.data.jpa.provider.HibernateUtils;
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

	public Integer addUser(UserEntity userentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userId = null; 
		
		if(isUserExists(userentity)) return userId;

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
		return userId;
	}

	public boolean isUserExists(UserEntity userentity) {
		Session session = factory.openSession();
		boolean result = false;
		try {
			Query query = session.createQuery("from UserEntity where emailID='" + userentity.getEmailID() + "'");
			UserEntity u = (UserEntity) query.uniqueResult();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List<UserEntity> getAllUsers() {
		Session session = factory.openSession();
		List<UserEntity> users = new ArrayList<UserEntity>();

		try {
			users = session.createQuery("FROM UserEntity").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public UserEntity authenticateuser(UserEntity userentity) {

		UserEntity user = getUserByemailId(userentity.getEmailID());
		if (user != null && user.getEmailID().equals(userentity.getEmailID()) && user.getPassword().equals(userentity.getPassword())) {
			return user;
		} else {
			return null;
		} 
	}
 
	private UserEntity getUserByemailId(String emailID) {
		Session session = factory.openSession();
		UserEntity user=null;

		try {
			Query query = session.createQuery("from UserEntity where emailID='" + emailID + "'");
			user = (UserEntity) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

}
