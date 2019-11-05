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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.SeekerJobPostStatus;
import com.sony.model.entity.User;
import com.sony.model.entity.UserDetail;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	private static SessionFactory factory;
	
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationDAOImpl.class);

	public CompanyDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public Integer addCompany(Company companyentity) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer companyId = null;

		try {
			tx = session.beginTransaction();
			companyId = (Integer) session.save(companyentity);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return companyId;
	}

	public Company getCompanyById(int companyId) {
		Session session = factory.openSession();
		Company result = null;
		try {
			Query query = session.createQuery("from Company where companyId='" + companyId + "'");
			Company company = (Company) query.uniqueResult();
			if (company != null)
				result = company;
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public List<CompanyDTO> getAllCompany() {
		Session session = factory.openSession();
		List<CompanyDTO> companies = new ArrayList<CompanyDTO>();

		try {
			List<Company> result = session.createQuery("FROM Company").list();
			if (!result.isEmpty()) {
				Iterator<Company> iterator = result.iterator();
				while (iterator.hasNext()) {
					Company company = iterator.next();
					CompanyDTO companydto = new CompanyDTO(company.getCompanyId(), company.getCompanyName(),
							company.getCompanyDescription(), company.getEstablishmentDate(), company.getWebsiteUrl(),
							company.getHeadquarter(), company.getSpecialities(), company.getIndustry(),
							company.getType());
					companies.add(companydto);
				}
				// jobposts.addAll(result);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return companies;
	}

	public int updateProfileImage(String profileImage, int userId) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer result = null;
		try {
			tx = session.beginTransaction();
			Query query = session
					.createQuery("update UserDetail set profileImage = :profileimage where userId=:userid");
			query.setParameter("profileimage", profileImage);
			query.setParameter("userid", userId);
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

	public UserDetail getUserById(int userId) {
		Session session = factory.openSession();
		logger.info("IDDDDD" + userId);
		UserDetail result = null;
		try {
			Query query = session.createQuery("from UserDetail where userId= :userid");
			query.setParameter("userid", userId);
			UserDetail user = (UserDetail) query.uniqueResult();
			logger.info("UserDei" + user.getName());
			if (user != null) {
				result = user;
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}
}
