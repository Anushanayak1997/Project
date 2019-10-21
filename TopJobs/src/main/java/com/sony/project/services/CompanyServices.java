package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.entities.JobPostEntity;
import com.sony.project.entities.UserEntity;
import com.sony.project.entities.CompanyDetailsEntity;

@Service
public class CompanyServices {

	LinkedList<CompanyDetailsEntity> company = new LinkedList<CompanyDetailsEntity>();
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	HttpSession httpSession;

	@Autowired
	EmployerCompanyService employercompany;

	public LinkedList<CompanyDetailsEntity> getCompany() {
		return company;
	}

	public int addCompanyName(String companyname) {
		int index, companyid;
		CompanyDetailsEntity companyDetails = new CompanyDetailsEntity();
		companyDetails.setCompanyName(companyname);
		company.add(companyDetails);
		index = company.indexOf(companyDetails);
		company.get(index).setCompanyId(index);
		companyid = company.get(index).getCompanyId();
		httpSession.setAttribute("companyid", companyid);
		//logger.info("Company ID", companyid);
		//logger.info("Company ID in add company name", httpSession.getAttribute("companyid"));
		employercompany.addEmployerCompany();
		return companyid;
	}

	public Integer addCompanyDetails(CompanyDetailsEntity companyDetails) {
		Iterator<CompanyDetailsEntity> iterator = company.iterator();
		while (iterator.hasNext()) {
			CompanyDetailsEntity companydetails = iterator.next();
			companyDetails.setCompanyName(companydetails.getCompanyName());
			if (companyDetails.getCompanyId() == (Integer) httpSession.getAttribute("companyid")) {
				company.set(company.indexOf(companydetails), companyDetails);
			}
			return (Integer) httpSession.getAttribute("companyid");
		}
		return (Integer) httpSession.getAttribute("companyid");
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
}
