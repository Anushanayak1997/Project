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
import com.sony.model.dto.SeekerSkillDTO;
import com.sony.model.dto.SkillSetDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.JobSeekerSkills;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.SkillSet;
import com.sony.model.entity.User;

@Repository
public class JobSeekerSkillDAOImpl implements JobSeekerSkillDAO {

	private static SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	public JobSeekerSkillDAOImpl() {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobSeekerSkill(JobSeekerSkills skill) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobseekerskillid = null;

		try {
			tx = session.beginTransaction();
			jobseekerskillid = (Integer) session.save(skill);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobseekerskillid;
	}

	public List<JobSeekerSkills> getAllSkills() {
		Session session = factory.openSession();
		List<JobSeekerSkills> skills = new ArrayList<JobSeekerSkills>();

		try {
			skills = session.createQuery("FROM JobSeekerSkills").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return skills;
	}

	public List<SeekerSkillDTO> getSeekerSkillById(int userId) {
		Session session = factory.openSession();
		List<SeekerSkillDTO> seekerprojects = new ArrayList<SeekerSkillDTO>();

		try {
			Query query = session.createQuery("from JobSeekerSkills where user.userID = :userId");
			query.setParameter("userId", userId);
			List<JobSeekerSkills> result = query.list();
			logger.info("Projects");
			if (seekerprojects != null) {
				Iterator<JobSeekerSkills> iterator = result.iterator();
				logger.info("userid"+userId);
				while (iterator.hasNext()) {
					JobSeekerSkills jobSeekerskill = iterator.next();
					User user = jobSeekerskill.getUser();
					SkillSet skillset = jobSeekerskill.getSkillset();
					UserDTO userdto = new UserDTO(user.getUserID(), user.getFirstName(), user.getLastName(),
							user.getEmailID(), user.getPassword(), user.getContactNumber(), user.getUserType());
					SkillSetDTO skilldto = new SkillSetDTO(skillset.getSkillId(), skillset.getSkillName());
					SeekerSkillDTO seekerskilldto = new SeekerSkillDTO(jobSeekerskill.getJobSeekerSkillId(),
							jobSeekerskill.getCertificateName(), jobSeekerskill.getIssuedDate(),
							userdto,skilldto);
					seekerprojects.add(seekerskilldto);
					logger.info("id"+seekerskilldto.getUserID());
				}
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return seekerprojects;
	}

	public void editSeekerSkill(JobSeekerSkills skills) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JobSeekerSkills initskills = (JobSeekerSkills) session.get(JobSeekerSkills.class,
					skills.getJobSeekerSkillId());
			// logger.info("userid"+user.getUserID());

			initskills.setCertificateName(skills.getCertificateName());
			initskills.setIssuedDate(skills.getIssuedDate());

			session.evict(skills);
			session.update(initskills);
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
