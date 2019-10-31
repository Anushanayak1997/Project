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
import com.sony.model.entity.Login;
import com.sony.model.entity.User;

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

	public Integer addUser(User userentity) {
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
	
	public User getUserById(int userId) {
		Session session = factory.openSession();
		User result = null;
		try {
			Query query = session.createQuery("from User where userID= :userid");
			query.setParameter("userid", userId);
			User user = (User) query.uniqueResult();
			if (user != null)
				result = user;
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public boolean isUserExists(User userentity) {
		Session session = factory.openSession();
		boolean result = false;
		try {
			Query query = session.createQuery("from User where emailID='" + userentity.getEmailID() + "'");
			User u = (User) query.uniqueResult();
			if (u != null)
				result = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List<User> getAllUsers() {
		Session session = factory.openSession();
		List<User> users = new ArrayList<User>();

		try {
			users = session.createQuery("FROM User").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public User authenticateuser(Login loginentity) {

		User user = getUserByemailId(loginentity.getEmailId());
		if (user != null && user.getEmailID().equals(loginentity.getEmailId()) && user.getPassword().equals(loginentity.getPassword())) {
			return user;
		} else {
			return null;
		} 
	}
 
	private User getUserByemailId(String emailID) {
		Session session = factory.openSession();
		User user=null;

		try {
			Query query = session.createQuery("from User where emailID='" + emailID + "'");
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

}
