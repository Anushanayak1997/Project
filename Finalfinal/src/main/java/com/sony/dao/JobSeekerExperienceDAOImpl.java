package com.sony.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.dto.SeekerProjectDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.User;

@Repository
public class JobSeekerExperienceDAOImpl implements JobSeekerExperienceDAO {

	private static SessionFactory factory;

	public JobSeekerExperienceDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerExperience(JobSeekerExperience experience) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerexperienceid = null;

		try {
			tx = session.beginTransaction();
			jobseekerexperienceid = (Integer) session.save(experience);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekerexperienceid;
	}

	public List<SeekerExperienceDTO> getAllSeekerExperience() {
		Session session = factory.openSession();
		List<SeekerExperienceDTO> experience = new ArrayList<SeekerExperienceDTO>();

		try {
			List<JobSeekerExperience> result = session.createQuery("FROM JobSeekerExperience").list();
			if (!result.isEmpty()) {
				Iterator<JobSeekerExperience> iterator = result.iterator();
				while (iterator.hasNext()) {
					JobSeekerExperience seekerexperience = iterator.next();
					SeekerExperienceDTO experiencedto = new SeekerExperienceDTO(
							seekerexperience.getJobSeekerExperienceId(), seekerexperience.getJobTitle(),
							seekerexperience.getStartDate(), seekerexperience.getEndDate(),
							seekerexperience.getJobDescription(), seekerexperience.getStreetAddress(),
							seekerexperience.getCity(), seekerexperience.getState(), seekerexperience.getUser());
					experience.add(experiencedto);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return experience;
	}

	public List<SeekerExperienceDTO> getExperienceById(int userId) {

		Session session = factory.openSession();
		List<SeekerExperienceDTO> result = new ArrayList<SeekerExperienceDTO>();
		try {
			Query query = session.createQuery("from JobSeekerExperience where user.userID= :userid");
			query.setParameter("userid", userId);
			List<JobSeekerExperience> seekerexperiences = query.list();
			if (seekerexperiences != null) {
				Iterator<JobSeekerExperience> iterator = seekerexperiences.iterator();
				while (iterator.hasNext()) {
					JobSeekerExperience seekerexperience = iterator.next();
					SeekerExperienceDTO experiencedto = new SeekerExperienceDTO(
							seekerexperience.getJobSeekerExperienceId(), seekerexperience.getJobTitle(),
							seekerexperience.getStartDate(), seekerexperience.getEndDate(),
							seekerexperience.getJobDescription(), seekerexperience.getStreetAddress(),
							seekerexperience.getCity(), seekerexperience.getState(), seekerexperience.getUser());
					result.add(experiencedto);
				}
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public void editSeekerExperience(JobSeekerExperience jobseekerexperience) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JobSeekerExperience initexperience = (JobSeekerExperience) session.get(JobSeekerExperience.class,
					jobseekerexperience.getJobSeekerExperienceId());
			initexperience.setJobTitle(jobseekerexperience.getJobTitle());

			// initjobpost.setIsActive(jobpost.getIsActive());
			// initjobpost.setNoOfVacancies(jobpost.getNoOfVacancies());
			//
			session.evict(jobseekerexperience);
			session.update(initexperience);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteSeekerExperience(int experienceId) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			JobSeekerExperience experience = (JobSeekerExperience) session.get(JobSeekerExperience.class, experienceId);
			session.delete(experience);
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
