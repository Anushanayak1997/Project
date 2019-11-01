package com.sony.model.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.dao.JobPostDAO;
import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.SkillSet;

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

	public Integer addJobPost(JobPostDTO jobpostdto) {
		// Integer companyid = (Integer) httpsession.getAttribute("companyid");
		Company company = companydao.getCompanyById(jobpostdto.getCompanyId());
		LinkedList<SkillSet> skillset = new LinkedList<SkillSet>();
		Iterator iterator = skillset.iterator();
		while(iterator.hasNext()) {
			
		}
		JobPost jobpost = new JobPost(jobpostdto.getJobPostId(), jobpostdto.getJobTitle(),
				jobpostdto.getJobDescription(), jobpostdto.isActive(), jobpostdto.getExperience(),
				jobpostdto.getNoOfApplicants(), jobpostdto.getPostDate(), jobpostdto.getNoOfVacancies(),
				jobpostdto.getStreetAddress(), jobpostdto.getCity(), jobpostdto.getState(), company,
				jobpostdto.getSkillset());
		// jobpostdto.setCompanyentity(company);
		Integer jobpostid = jobpostdao.addJobPost(jobpost);
		// httpsession.setAttribute("jobpostid", jobpostid);
		if (jobpostid != null)
			return jobpostid;
		else {
			return null;
		}
	}

	public JobPost getJobById(Integer jobpostid) {
		return jobpostdao.getJobById(jobpostid);
	}

}
