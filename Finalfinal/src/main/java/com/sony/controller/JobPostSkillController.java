package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobPostSkill;

import com.sony.model.service.JobPostSkillService;

@RestController
public class JobPostSkillController {
	
	@Autowired
	JobPostSkillService jobpostskillservice;

	@RequestMapping(value = "/addjobskill", method = RequestMethod.POST)
	public boolean addJobSkill(@RequestBody JobPostSkill jobpost_skill) {
		return jobpostskillservice.addJobSkill(jobpost_skill);
	}
}
