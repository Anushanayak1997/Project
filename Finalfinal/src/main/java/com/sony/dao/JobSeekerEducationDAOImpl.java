package com.sony.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.sony.model.dto.EducationDTO;
import com.sony.model.dto.SkillSetDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.SkillSet;
import com.sony.model.entity.User;

import oracle.net.aso.l;

@Repository
public class JobSeekerEducationDAOImpl implements JobSeekerEducationDAO {

	private static SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationDAOImpl.class);

	public JobSeekerEducationDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerEducation(JobSeekerEducation education) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekereducationid = null;

		try {
			tx = session.beginTransaction();
			jobseekereducationid = (Integer) session.save(education);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekereducationid;
	}

	public List<EducationDTO> getAllSeekerEducation() {
		Session session = factory.openSession();
		List<EducationDTO> seekereducation = new ArrayList<EducationDTO>();

		try {
			List<JobSeekerEducation> education = session.createQuery("FROM JobSeekerEducation").list();

			Iterator<JobSeekerEducation> iterators = education.iterator();
			while (iterators.hasNext()) {
				JobSeekerEducation edu = iterators.next();
				EducationDTO educationdto = new EducationDTO(edu);
				seekereducation.add(educationdto);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return seekereducation;
	}

	public List<EducationDTO> getSeekerEducationById(int userId) {
		Session session = factory.openSession();
		List<EducationDTO> result = new ArrayList<EducationDTO>();
		try {
			Query query = session.createQuery("from JobSeekerEducation where user.userID= :userid");
			query.setParameter("userid", userId);
			List<JobSeekerEducation> education = query.list();
			if (education != null) { 
				Iterator<JobSeekerEducation> iterators = education.iterator(); 
				while (iterators.hasNext()) {
					JobSeekerEducation edu = iterators.next();
					logger.info("EDDDDDDD" + edu.getEducationType());
					EducationDTO educationdto = new EducationDTO(edu);
					logger.info("EDDDDDDhhhD" + educationdto.getEducationType());
					result.add(educationdto);
				}
			}
			logger.info("SIZERRR" + result.size());
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public void editSeekerEducation(JobSeekerEducation jobSeekerEducation) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JobSeekerEducation initseekereducation = (JobSeekerEducation) session.get(JobSeekerEducation.class,
					jobSeekerEducation.getJobSeekerEducationId());
			// initseekereducation.setStartingDate(jobSeekerEducation.getStartingDate());
			logger.info("education");
			// initseekereducation.setEndingDate(jobSeekerEducation.getEndingDate());
			// initseekereducation.setEducationType(jobSeekerEducation.getEducationType());
			initseekereducation.setMarksPercentages(jobSeekerEducation.getMarksPercentages());
			// initseekereducation.setSpecialization(jobSeekerEducation.getSpecialization());
			session.evict(jobSeekerEducation);
			session.update(initseekereducation);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteSeekerEducation(int educationId) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			JobSeekerEducation education = (JobSeekerEducation) session.get(JobSeekerEducation.class, educationId);
			session.delete(education);
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
