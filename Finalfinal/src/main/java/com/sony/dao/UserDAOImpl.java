package com.sony.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sony.controller.CompanyController;

import com.sony.model.entity.JobSeekerProject;

import com.sony.model.dto.JobPostDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobPost;

import com.sony.model.entity.Login;
import com.sony.model.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

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

		if (isUserExists(userentity))
			return userId;

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

	public UserDTO getUserById(int userId) {
		Session session = factory.openSession();
		UserDTO result = null;
		try {
			Query query = session.createQuery("from User where userID= :userid");
			query.setParameter("userid", userId);
			User user = (User) query.uniqueResult();
			if (user != null) {
				result = new UserDTO(user.getUserID(),user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmailID(), user.getContactNumber(), user.getUserType());
			}
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

	public List<UserDTO> getAllUsers() {
		Session session = factory.openSession();
		List<UserDTO> users = new ArrayList<UserDTO>();

		try {
			List<User> result = session.createQuery("FROM User").list();
			if (!result.isEmpty()) {
				Iterator<User> iterator = result.iterator();
				while (iterator.hasNext()) {
					User user = iterator.next();
					UserDTO userdto = new UserDTO(user.getUserID(), user.getPassword(), user.getFirstName(),
							user.getLastName(), user.getEmailID(), user.getContactNumber(), user.getUserType());
					users.add(userdto);
				}
				// jobposts.addAll(result);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public User authenticateuser(Login loginentity) {

		User user = getUserByemailId(loginentity.getEmailId());
		if (user != null && user.getEmailID().equals(loginentity.getEmailId())
				&& user.getPassword().equals(loginentity.getPassword())) {
			return user;
		} else {
			return null;
		}
	}

	private User getUserByemailId(String emailID) {
		Session session = factory.openSession();
		User user = null;

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

	public void editUser(User user) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User inituser = (User) session.get(User.class, user.getUserID());
		//	logger.info("userid"+user.getUserID());
			
			inituser.setFirstName(user.getFirstName());
			inituser.setLastName(user.getLastName());
			inituser.setEmailID(user.getEmailID());
			inituser.setContactNumber(user.getContactNumber());
			session.evict(user);
			session.update(inituser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
