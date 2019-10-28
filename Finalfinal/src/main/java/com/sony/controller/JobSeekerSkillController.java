package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.JobSeekerSkills;
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
	public boolean addJobSeekerSkill(@RequestBody JobSeekerSkills skills) {
		return jobseekerskillservice.addJobSeekerSkill(skills);
	}
}
