package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sony.project.dao.CompanyDAO;
import com.sony.project.dao.CompanyDAOImpl;
import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.entities.JobPostEntity;

@Service
public class CompanyServicesImpl implements CompanyService {

	LinkedList<CompanyDetailsEntity> company = new LinkedList<CompanyDetailsEntity>();


	@Autowired
	HttpSession httpSession;

	@Autowired	
	EmployerCompanyService employercompany;
	
	
	private CompanyDAOImpl companyDAOImpl;

	public LinkedList<CompanyDetailsEntity> getCompany() {
		return company;
	}

//	public void addCompanyName(String companyname) {
//		//int index, companyid;
//		CompanyDetailsEntity companyDetails = new CompanyDetailsEntity();
//		companyDetails.setCompanyName(companyname);
//		company.add(companyDetails);
//		//index = company.indexOf(companyDetails);
//		//company.get(index).setCompanyId(index);
//		//companyid = company.get(index).getCompanyId();
//		// httpSession.setAttribute("companyid", companyid);
//		// employercompany.addEmployerCompany();
//		companyDAO.addCompanyDetails(companyDetails);
//	}

	public Integer addCompanyDetails(CompanyDetailsEntity companyDetails) {
		
		//Iterator<CompanyDetailsEntity> iterator = company.iterator();
//		CompanyDetailsEntity companydetails = null;
//		while (iterator.hasNext()) {
//			companydetails = iterator.next();
//			if (companydetails.getCompanyId() == (Integer) httpSession.getAttribute("companyid")) {
//				companyDetails.setCompanyName(companydetails.getCompanyName());
//				companyDetails.setCompanyId(companydetails.getCompanyId());
//				company.set(company.indexOf(companydetails), companyDetails);
//			}
//		}
//		return companyDetails;
			return companyDAOImpl.addCompanyDetails(companyDetails);
			
	}

	public CompanyDetailsEntity getCompanyDetails(int id) {
		Iterator<CompanyDetailsEntity> iterator = company.iterator();
		while (iterator.hasNext()) {
			CompanyDetailsEntity companyDetails = iterator.next();
			if (companyDetails.getCompanyId() == id) {
				return companyDetails;
			}
		}
		return null;
	}

	public void updateCompanyDetails(int id, CompanyDetailsEntity obj) {
		Iterator<CompanyDetailsEntity> iterator = company.iterator();
		while (iterator.hasNext()) {
			CompanyDetailsEntity companyDetails = iterator.next();
			if (companyDetails.getCompanyId() == id) {
				int index = company.indexOf(companyDetails);
				company.set(index, obj);
			}
		}
	}

	public void deleteCompanyDetails(int id) {
		Iterator<CompanyDetailsEntity> iterator = company.iterator();
		while (iterator.hasNext()) {
			CompanyDetailsEntity companyDetails = iterator.next();
			if (companyDetails.getCompanyId() == id) {
				int index = company.indexOf(company);
				company.remove(index);
			}
		}
	}

	public Integer addJobPost(JobPostEntity jobpostentity) {
		int companyid = (Integer) httpSession.getAttribute("companyid");
		CompanyDetailsEntity companydetails = company.get(companyid);
		// companydetails.getJobposts().add(jobpostentity);
		LinkedList<JobPostEntity> jobposts = companydetails.getJobposts();
		if (!jobposts.isEmpty()) {
			int lastid = jobposts.getLast().getJobPostId();
			if (lastid >= 0) {
				jobpostentity.setJobPostId(lastid + 1);
			} else {
				jobpostentity.setJobPostId(0);
			}
		}
		jobposts.add(jobpostentity);
		return (Integer) httpSession.getAttribute("companyid");
	}
}
