package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.dao.JobPostDAO;

import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;

@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostDAO jobpostdao;

	@Autowired
	private CompanyDAO companydao;

	@Autowired
	HttpSession httpsession;

	public List<JobPost> getJobsByCompId() {
		Integer companyid = (Integer) httpsession.getAttribute("companyid");
		Company company = companydao.getCompanyById(companyid);
		return jobpostdao.getJobsByCompId(company);
	}

	public boolean addJobPost(JobPost jobpostentity) {
		Integer companyid = (Integer) httpsession.getAttribute("companyid");
		Company company = companydao.getCompanyById(companyid);
		jobpostentity.setCompanyentity(company);
		Integer jobpostid = jobpostdao.addJobPost(jobpostentity);
		httpsession.setAttribute("jobpostid", jobpostid);
		if (jobpostid != null)
			return true;
		else {
			return false;
		}
	}
	
	public JobPost getJobById(Integer jobpostid) {
		return jobpostdao.getJobById(jobpostid);
	}

}
