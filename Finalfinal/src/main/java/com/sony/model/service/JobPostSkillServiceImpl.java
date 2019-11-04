package com.sony.model.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobPostSkillDAO;
import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobPostSkill;


@Service
public class JobPostSkillServiceImpl implements JobPostSkillService{
	
	@Autowired
	JobPostSkillDAO jobpostskilldao;
	
	@Autowired
	JobPostService jobpostservice;
	
	@Autowired
	HttpSession httpsession;

//	public boolean addJobSkill(SkillSet skillset) {
//		boolean status = false;
//		JobPostSkill jobpostskill = new JobPostSkill();
//		Integer jobpostid = (Integer) httpsession.getAttribute("jobpostid");
//		JobPost jobpost = jobpostservice.getJobById(jobpostid);
//		jobpostskill.setJobpost(jobpost);
//		jobpostskill.setSkillset(skillset);
//		if(jobpostskilldao.addJobSkill(jobpostskill) != null ) {
//			status = true;
//		}
//		return status;
//	}

	public boolean addJobSkill(JobPostSkill jobpost_skill) {
		boolean status = false;
		JobPostSkill jobpostskill = new JobPostSkill();
		// Integer jobpostid = (Integer) httpsession.getAttribute("jobpostid");
		Integer jobpostid = jobpost_skill.getJobpost().getJobPostId();
		JobPostDTO jobpostdto = jobpostservice.getJobById(jobpostid);
		JobPost jobpost = new JobPost(jobpostdto);
		jobpostskill.setJobpost(jobpost);
		jobpostskill.setSkillset(jobpost_skill.getSkillset());
	//	jobpostskill.setSkilllevel(jobpost_skill.getSkilllevel());
		if(jobpostskilldao.addJobSkill(jobpostskill) != null ) {
			status = true;
		}
		return status;
	}
}
