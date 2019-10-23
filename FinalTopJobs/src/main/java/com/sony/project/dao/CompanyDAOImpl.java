package com.sony.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.entities.JobPostEntity;

@Repository
public class CompanyDAOImpl implements CompanyDAO{

	@Autowired
	private SessionFactory factory;

//	public void addCompanyName(String companyname) {
//	      Session session = factory.openSession();
//	      Transaction tx = null;
//	      Integer companyId = null;
//	      
//	      try {
//	         tx = session.beginTransaction();
//	         companyId = (Integer) session.save(); 
//	         tx.commit();
//	      } catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      } finally {
//	         session.close(); 
//	      }
//	}

	@Transactional
	public Integer addCompanyDetails(CompanyDetailsEntity companyDetails) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer companyId = -1;
	      
	      try {
	         tx = session.beginTransaction();
	         session.save(companyDetails); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return companyId;
		
	}

	public CompanyDetailsEntity getCompanyDetails(int id) {
		return null;
	}

	public void updateCompanyDetails(int id, CompanyDetailsEntity obj) {
		
	}

	public void deleteCompanyDetails(int id) {
		
	}

	public Integer addJobPost(JobPostEntity jobpostentity) {

		return null;
	}
}
