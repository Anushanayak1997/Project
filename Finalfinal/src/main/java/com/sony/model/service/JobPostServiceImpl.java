package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.dao.JobPostDAO;
import com.sony.dao.LocationDAO;
import com.sony.model.entity.CompanyEntity;
import com.sony.model.entity.JobPostEntity;

@Service
public class JobPostServiceImpl implements JobPostService {
 
	@Autowired          
	private JobPostDAO jobpostdao;
	
	@Autowired
	private CompanyDAO companydao;
	
	@Autowired
	private LocationDAO locationdao;
    
	@Autowired
	HttpSession httpsession;

	public List<JobPostEntity> getJobsByCompId() {
		Integer companyid = (Integer) httpsession.getAttribute("companyid");
		CompanyEntity company = companydao.getCompanyById(companyid);
		return jobpostdao.getJobsByCompId(company);
	}
    
    
	public boolean addJobPost(JobPostEntity jobpostentity) { 
		Integer companyid = (Integer) httpsession.getAttribute("companyid");
		CompanyEntity company = companydao.getCompanyById(companyid);
		jobpostentity.setCompanyentity(company);
		Integer jobpostid = jobpostdao.addJobPost(jobpostentity);
		if(jobpostid != null)
			return true;
		else {
			return false;
		}
	}



}
