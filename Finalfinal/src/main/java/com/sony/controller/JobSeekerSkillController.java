package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SeekerSkillDTO;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.JobSeekerSkills;
import com.sony.model.entity.User;
import com.sony.model.service.JobSeekerSkillService;

@RestController 
public class JobSeekerSkillController { 
	@Autowired
	public JobSeekerSkillService jobseekerskillservice;
	
	
	@RequestMapping(value = "/getallseekerskills")
	public List<JobSeekerSkills> getAllSkill() {
		return jobseekerskillservice.getAllSkills();
	}
	
	@RequestMapping(value = "/addjobseekerskill", method = RequestMethod.POST)
	public Integer addJobSeekerSkill(@RequestBody SeekerSkillDTO skills) {
		return jobseekerskillservice.addJobSeekerSkill(skills);
	}
	
	@RequestMapping(value = "/getseekerskillbyid/{userId}")
	public List<SeekerSkillDTO> getSeekerSkillById(@PathVariable int userId) {
		if(jobseekerskillservice.getSeekerSkillById(userId) != null) {
			return jobseekerskillservice.getSeekerSkillById(userId);
		}
		else {
			return null;
		}
	}
	@RequestMapping(value = "/editseekerskill", method = RequestMethod.PUT)
	public void editSeekerSkill(@RequestBody JobSeekerSkills skills) {
		jobseekerskillservice.editSeekerSkill(skills);
	}

}
