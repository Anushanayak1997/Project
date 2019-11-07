package com.sony.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
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
import com.sony.model.entity.Avatar;

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

	public CompanyDTO getCompanyById(int companyId) {
		Session session = factory.openSession();
		CompanyDTO result = null;
		try {
			Query query = session.createQuery("from Company where companyId= :companyid");
			query.setParameter("companyid", companyId);
			Company company = (Company) query.uniqueResult();
			if (company != null) {
				result = new CompanyDTO(company);
				String image = Base64.getEncoder().encodeToString(company.getImage());
				result.setCompimage(image);
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}

	public List<CompanyDTO> getAllCompany() {
		Session session = factory.openSession();
		List<CompanyDTO> companies = new ArrayList<CompanyDTO>();
		String image = null;
		try {
			List<Company> result = session.createQuery("FROM Company").list();
			if (!result.isEmpty()) {
				Iterator<Company> iterator = result.iterator();
				while (iterator.hasNext()) {
					Company company = iterator.next();
					image = Base64.getEncoder().encodeToString(company.getImage());
					logger.info("Imageeeeeeeee" + image);
					CompanyDTO companydto = new CompanyDTO(company.getCompanyId(), company.getCompanyName(),
							company.getCompanyDescription(), company.getEstablishmentDate(), company.getWebsiteUrl(),
							company.getHeadquarter(), company.getSpecialities(), company.getIndustry(),
							company.getType(), image);
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

	
//-------------------------------------------------UploadImage------------------------------------------------------------------//
	public Integer addImage(byte[] file) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer id = null;
		try {
			tx = session.beginTransaction();
			Avatar avatar = new Avatar();
	        avatar.setImage(file);
	        id = (Integer) session.save(avatar);
	        tx.commit();
	    } catch (Exception e) {
	    	if(tx != null) {
	    		tx.rollback();
	    	}
		     e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	public String getImage(int avatarId) {
		Session session = factory.openSession();
		byte[] bAvatar = null;
		Avatar avatar = new Avatar();
		String result = null;
		try {
			Query query = session.createQuery("from Avatar where avatarId= :avatarid");
			query.setParameter("avatarid", avatarId);
			avatar = (Avatar) query.uniqueResult();
			bAvatar = avatar.getImage();
			if (bAvatar != null) {
				result = Base64.getEncoder().encodeToString(bAvatar);
			}
		} catch (Exception ex) {
		} finally {
			session.close();
		}
		return result;
	}
}