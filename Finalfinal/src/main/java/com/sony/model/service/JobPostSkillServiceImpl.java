package com.sony.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobPostSkillDAO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobPostSkill;
import com.sony.model.entity.SkillSet;

@Service
public class JobPostSkillServiceImpl implements JobPostSkillService{
	
	@Autowired
	JobPostSkillDAO jobpostskilldao;
	
	@Autowired
	JobPostService jobpostservice;
	
	@Autowired
	HttpSession httpsession;

	public boolean addJobSkill(SkillSet skillset) {
		boolean status = false;
		JobPostSkill jobpostskill = new JobPostSkill();
		Integer jobpostid = (Integer) httpsession.getAttribute("jobpostid");
		JobPost jobpost = jobpostservice.getJobById(jobpostid);
		jobpostskill.setJobpost(jobpost);
		jobpostskill.setSkillset(skillset);
		if(jobpostskilldao.addJobSkill(jobpostskill) != null ) {
			status = true;
		}
		return status;
	}

}
