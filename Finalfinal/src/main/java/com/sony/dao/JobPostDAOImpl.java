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

import com.sony.model.dto.JobPostDTO;
import com.sony.model.dto.SeekerJobPostDTO;
import com.sony.model.dto.SkillSetDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.EmployerCompany;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.SkillSet;
import com.sony.model.entity.User;

@Repository
public class JobPostDAOImpl implements JobPostDAO {

	private static SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(JobPostDAOImpl.class);

	public JobPostDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addJobPost(JobPost jobpostentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer jobpostId = null;

		try {
			tx = session.beginTransaction();
			jobpostId = (Integer) session.save(jobpostentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobpostId;

	}

	public List<JobPostDTO> getJobsByCompId(Company company) {
		Session session = factory.openSession();
		List<JobPostDTO> jobposts = new ArrayList<JobPostDTO>();
		Integer companyId = company.getCompanyId();

		try {
			String hql = "FROM JobPost where companyentity.companyId = :companyid";
			Query query = session.createQuery(hql);
			query.setParameter("companyid", companyId);
			List<JobPost> result = query.list();
			if (!result.isEmpty()) {
				Iterator<JobPost> iterator = result.iterator();
				while (iterator.hasNext()) {
					
					JobPost jobpost = iterator.next();
					Iterator<SkillSet> iterators = jobpost.getSkillset().iterator();
					Set<SkillSetDTO> skillsets = new HashSet<SkillSetDTO>();
					
					while (iterators.hasNext()) {
						SkillSet skillset = iterators.next();
						SkillSetDTO skillsetdto = new SkillSetDTO(skillset.getSkillId(), skillset.getSkillName());
						skillsets.add(skillsetdto);
					}
					
					JobPostDTO jobpostdto = new JobPostDTO(jobpost.getJobPostId(), jobpost.getJobTitle(),
							jobpost.getJobDescription(), jobpost.getIsActive(), jobpost.getExperience(),
							jobpost.getNoOfApplicants(), jobpost.getPostDate(), jobpost.getNoOfVacancies(),
							jobpost.getStreetAddress(), jobpost.getCity(), jobpost.getState(), skillsets,
							jobpost.getCompanyentity());
					jobposts.add(jobpostdto);
				}
				// jobposts.addAll(result);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobposts;
	}

	public JobPostDTO getJobById(Integer jobpostid) {
		Session session = factory.openSession();
		JobPostDTO jobpostdto = null;
		try {
			String hql = "FROM JobPost where jobPostId = :jobpostid";
			Query query = session.createQuery(hql);
			query.setParameter("jobpostid", jobpostid);
			JobPost job = (JobPost) query.uniqueResult();
			if (job != null) {
				
				Iterator<SkillSet> iterators = job.getSkillset().iterator();
				Set<SkillSetDTO> skillsets = new HashSet<SkillSetDTO>();
				
				while (iterators.hasNext()) {
					SkillSet skillset = iterators.next();
					SkillSetDTO skillsetdto = new SkillSetDTO(skillset.getSkillId(), skillset.getSkillName());
					skillsets.add(skillsetdto);
				}
				jobpostdto = new JobPostDTO(job.getJobPostId(), job.getJobTitle(), job.getJobDescription(),
						job.getIsActive(), job.getExperience(), job.getNoOfApplicants(), job.getPostDate(),
						job.getNoOfVacancies(), job.getStreetAddress(), job.getCity(), job.getState(),
						skillsets, job.getCompanyentity());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobpostdto;
	}

	public List<JobPostDTO> getAllJobs() {
		Session session = factory.openSession();
		List<JobPostDTO> jobposts = new ArrayList<JobPostDTO>();
		try {
			String hql = "FROM JobPost";
			Query query = session.createQuery(hql);
			List<JobPost> result = query.list();
			if (!result.isEmpty()) {
				// jobposts.addAll(result);
				Iterator<JobPost> iterator = result.iterator();
				while (iterator.hasNext()) {
					JobPost jobpost = iterator.next();
					Iterator<SkillSet> iterators = jobpost.getSkillset().iterator();
					Set<SkillSetDTO> skillsets = new HashSet<SkillSetDTO>();
					
					while (iterator.hasNext()) {
						SkillSet skillset = iterators.next();
						SkillSetDTO skillsetdto = new SkillSetDTO(skillset.getSkillId(), skillset.getSkillName());
						skillsets.add(skillsetdto);
					}
					JobPostDTO jobpostdto = new JobPostDTO(jobpost.getJobPostId(), jobpost.getJobTitle(),
							jobpost.getJobDescription(), jobpost.getIsActive(), jobpost.getExperience(),
							jobpost.getNoOfApplicants(), jobpost.getPostDate(), jobpost.getNoOfVacancies(),
							jobpost.getStreetAddress(), jobpost.getCity(), jobpost.getState(), skillsets,
							jobpost.getCompanyentity());
					jobposts.add(jobpostdto);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return jobposts;
	}

	public void editJobPost(JobPost jobpost) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			JobPost initjobpost = (JobPost) session.get(JobPost.class, jobpost.getJobPostId());
			initjobpost.setIsActive(jobpost.getIsActive());
			initjobpost.setNoOfVacancies(jobpost.getNoOfVacancies());
			session.evict(jobpost);
			session.update(initjobpost);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteJobPost(int jobpostid) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			JobPost jobpost = (JobPost) session.get(JobPost.class, jobpostid);
			session.delete(jobpost);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Integer updateNoApplicants(int jobpostId) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.beginTransaction();
			// UPDATE Tag t set t.count = t.count + 1 WHERE t.id = :id;
			Query query = session
					.createQuery("update JobPost set noOfApplicants = noOfApplicants + 1 where jobPostId = :jobpostid");
			query.setParameter("jobpostid", jobpostId);
			result = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;

	}
}
