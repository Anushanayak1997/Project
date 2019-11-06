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
import com.sony.model.dto.CompanyDTO;
import com.sony.model.dto.SeekerProjectDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.JobSeekerProject;

@Repository
public class JobSeekerProjectDAOImpl implements JobSeekerProjectDAO {

	private static SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	public JobSeekerProjectDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerProject(JobSeekerProject project) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerprojectid = null;

		try {
			tx = session.beginTransaction();
			jobseekerprojectid = (Integer) session.save(project);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekerprojectid;
	}

	public List<SeekerProjectDTO> getAllProject() {
		Session session = factory.openSession();
		List<SeekerProjectDTO> project = new ArrayList<SeekerProjectDTO>();

		try {
			List<JobSeekerProject> result = session.createQuery("FROM JobSeekerProject").list();
			if (!result.isEmpty()) {
				Iterator<JobSeekerProject> iterator = result.iterator();
				while (iterator.hasNext()) {
					JobSeekerProject seekerproject = iterator.next();
					SeekerProjectDTO projectdto = new SeekerProjectDTO(seekerproject.getJobSeekerProjectId(),
							seekerproject.getTitle(), seekerproject.getDescription(), seekerproject.getRole(),
							seekerproject.getUser());
					project.add(projectdto);

				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return project;
	}

	public List<SeekerProjectDTO> getProjectsById(int userId) {
		Session session = factory.openSession();
		List<SeekerProjectDTO> result = new ArrayList<SeekerProjectDTO>();
		try {
			Query query = session.createQuery("from JobSeekerProject where user.userID = :userId");
			query.setParameter("userId", userId);
			List<JobSeekerProject> seekerprojects =  query.list();
			logger.info("Projects");
			if (seekerprojects != null) {
				Iterator<JobSeekerProject> iterator = seekerprojects.iterator();
				while (iterator.hasNext()) {
					JobSeekerProject seekerproject = iterator.next();
					SeekerProjectDTO projectdto = new SeekerProjectDTO(seekerproject.getJobSeekerProjectId(),
							seekerproject.getTitle(), seekerproject.getDescription(), seekerproject.getRole(),
							seekerproject.getUser());

					result.add(projectdto);
				}
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public void editSeekerProject(JobSeekerProject jobSeekerproject) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JobSeekerProject initproject = (JobSeekerProject) session.get(JobSeekerProject.class,
					jobSeekerproject.getJobSeekerProjectId());
			initproject.setDescription(jobSeekerproject.getDescription());
			initproject.setRole(jobSeekerproject.getRole());
			initproject.setTitle(jobSeekerproject.getTitle());
			session.evict(jobSeekerproject);
			session.update(initproject);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteSeekerProject(int projectId) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			JobSeekerProject project = (JobSeekerProject) session.get(JobSeekerProject.class, projectId);
			session.delete(project);
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
