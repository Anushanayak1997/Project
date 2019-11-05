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

import com.sony.model.dto.CompanyDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.User;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	private static SessionFactory factory;

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
}
