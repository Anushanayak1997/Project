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

import com.sony.model.dto.JobPostDTO;
import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.User;

@Repository
public class SeekerJobPostDAOImpl implements SeekerJobPostDAO {

	private static SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(SeekerJobPostDAOImpl.class);

	public SeekerJobPostDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addSeekerJobPost(SeekerJobPostStatus seekerjobpost) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer seekerjobpostId = null;

		try {
			tx = session.beginTransaction();
			seekerjobpostId = (Integer) session.save(seekerjobpost);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return seekerjobpostId;
	}

	public void updateStatus(SeekerJobPostDTO seekerjobpostdto) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			SeekerJobPostStatus initseekerjobpost = (SeekerJobPostStatus) session.get(SeekerJobPostStatus.class, seekerjobpostdto.getId());
			initseekerjobpost.setStatus(seekerjobpostdto.getStatus());
			initseekerjobpost.setNotificationStatus(seekerjobpostdto.getNotificationStatus());
			session.update(initseekerjobpost);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<SeekerJobPostDTO> getApplicantsById(int jobpostId) {
		Session session = factory.openSession();
		List<SeekerJobPostDTO> applicants = new ArrayList<SeekerJobPostDTO>();
		try {
			String hql = "FROM SeekerJobPostStatus where jobpost.jobPostId = :jobpostid";
			Query query = session.createQuery(hql);
			query.setParameter("jobpostid", jobpostId);

			List<SeekerJobPostStatus> result = query.list();
			if (!result.isEmpty()) {
				Iterator<SeekerJobPostStatus> iterator = result.iterator();
				while (iterator.hasNext()) {
					SeekerJobPostStatus seekerjobpost = iterator.next();
					User user = seekerjobpost.getUser();
					JobPost jobpost = seekerjobpost.getJobpost();
					UserDTO userdto = new UserDTO(user.getUserID(), user.getPassword(), user.getFirstName(),
							user.getLastName(), user.getEmailID(), user.getContactNumber(), user.getUserType());
					JobPostDTO jobpostdto = new JobPostDTO(jobpost.getJobPostId(), jobpost.getJobTitle(),
							jobpost.getJobDescription(), jobpost.getIsActive(), jobpost.getExperience(),
							jobpost.getNoOfApplicants(), jobpost.getPostDate(), jobpost.getNoOfVacancies(),
							jobpost.getStreetAddress(), jobpost.getCity(), jobpost.getState(), jobpost.getSkillset(), jobpost.getCompanyentity());
					SeekerJobPostDTO seekerjobpostdto = new SeekerJobPostDTO(seekerjobpost.getId(),seekerjobpost.getStatus(),
							seekerjobpost.getNotificationStatus(), userdto, jobpostdto);
					applicants.add(seekerjobpostdto);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return applicants;
	}

	public List<SeekerJobPostDTO> getApplicantsByUserId(int userId) {
		Session session = factory.openSession();
		List<SeekerJobPostDTO> applicants = new ArrayList<SeekerJobPostDTO>();
		try {
			String hql = "FROM SeekerJobPostStatus where user.userID = :userid";
			Query query = session.createQuery(hql);
			query.setParameter("userid", userId);

			List<SeekerJobPostStatus> result = query.list();
			if (!result.isEmpty()) { 
				Iterator<SeekerJobPostStatus> iterator = result.iterator(); 
				while (iterator.hasNext()) {
					SeekerJobPostStatus seekerjobpost = iterator.next();
					User user = seekerjobpost.getUser();
					JobPost jobpost = seekerjobpost.getJobpost();
					UserDTO userdto = new UserDTO(user.getUserID(), user.getPassword(), user.getFirstName(),
							user.getLastName(), user.getEmailID(), user.getContactNumber(), user.getUserType());
					JobPostDTO jobpostdto = new JobPostDTO(jobpost.getJobPostId(), jobpost.getJobTitle(),
							jobpost.getJobDescription(), jobpost.getIsActive(), jobpost.getExperience(),
							jobpost.getNoOfApplicants(), jobpost.getPostDate(), jobpost.getNoOfVacancies(),
							jobpost.getStreetAddress(), jobpost.getCity(), jobpost.getState(), jobpost.getSkillset(), jobpost.getCompanyentity());
					SeekerJobPostDTO seekerjobpostdto = new SeekerJobPostDTO(seekerjobpost.getId(),seekerjobpost.getStatus(),
							seekerjobpost.getNotificationStatus(), userdto, jobpostdto);
					applicants.add(seekerjobpostdto);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return applicants;
	}
	
	public List<SeekerJobPostDTO> getSelectedUsers(int jobpostId) {
		Session session = factory.openSession();
		List<SeekerJobPostDTO> applicants = new ArrayList<SeekerJobPostDTO>();
		try {
			String hql = "FROM SeekerJobPostStatus where jobpost.jobPostId = :jobpostid and status = :statusvalue";
			Query query = session.createQuery(hql);
			query.setParameter("jobpostid", jobpostId);
			query.setParameter("statusvalue", "Selected");

			List<SeekerJobPostStatus> result = query.list();
			if (!result.isEmpty()) {
				Iterator<SeekerJobPostStatus> iterator = result.iterator();
				while (iterator.hasNext()) {
					SeekerJobPostStatus seekerjobpost = iterator.next();
					User user = seekerjobpost.getUser();
					JobPost jobpost = seekerjobpost.getJobpost();
					UserDTO userdto = new UserDTO(user.getUserID(), user.getPassword(), user.getFirstName(),
							user.getLastName(), user.getEmailID(), user.getContactNumber(), user.getUserType());
					JobPostDTO jobpostdto = new JobPostDTO(jobpost.getJobPostId(), jobpost.getJobTitle(),
							jobpost.getJobDescription(), jobpost.getIsActive(), jobpost.getExperience(),
							jobpost.getNoOfApplicants(), jobpost.getPostDate(), jobpost.getNoOfVacancies(),
							jobpost.getStreetAddress(), jobpost.getCity(), jobpost.getState(), jobpost.getSkillset(), jobpost.getCompanyentity());
					SeekerJobPostDTO seekerjobpostdto = new SeekerJobPostDTO(seekerjobpost.getId(),seekerjobpost.getStatus(),
							seekerjobpost.getNotificationStatus(), userdto, jobpostdto);
					applicants.add(seekerjobpostdto);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return applicants;
	}

}
