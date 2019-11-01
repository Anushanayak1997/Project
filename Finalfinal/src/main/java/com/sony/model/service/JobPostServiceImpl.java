package com.sony.model.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.dao.JobPostDAO;
import com.sony.dao.JobSeekerEducationDAOImpl;
import com.sony.dao.SkillSetDAO;
import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.SkillSet;

@Service
public class JobPostServiceImpl implements JobPostService {
	
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationDAOImpl.class);

	@Autowired
	private JobPostDAO jobpostdao;

	@Autowired
	private CompanyDAO companydao;
	
	@Autowired
	private SkillSetDAO skilldao;

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
		// logger.info("Skill set yyyyy" + jobpostdto.getSkillset().get(0).getSkillId() + jobpostdto.getSkillset().get(0).getSkillName() );
		
		LinkedList<SkillSet> skillset = new LinkedList<SkillSet>();
		Iterator<SkillSet> iterator = jobpostdto.getSkillset().iterator();
		while(iterator.hasNext()) {
			SkillSet skill = iterator.next();
			skillset.add(skilldao.getSkillById(skill.getSkillName()));
		}
		
		logger.info("Skill set yyyyy" + skillset.get(0).getSkillId() + skillset.get(0).getSkillName() );
		JobPost jobpost = new JobPost(jobpostdto.getJobPostId(), jobpostdto.getJobTitle(),
				jobpostdto.getJobDescription(), jobpostdto.isActive(), jobpostdto.getExperience(),
				jobpostdto.getNoOfApplicants(), jobpostdto.getPostDate(), jobpostdto.getNoOfVacancies(),
				jobpostdto.getStreetAddress(), jobpostdto.getCity(), jobpostdto.getState(), company);
		
		jobpost.setSkillset(skillset);
		Integer jobpostid = jobpostdao.addJobPost(jobpost);
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
