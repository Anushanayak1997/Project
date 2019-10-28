package com.sony.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.JobSeekerProject;
import com.sony.model.service.JobSeekerExperienceService;

@RestController
public class JobSeekerExperienceController {
	
	@Autowired
	JobSeekerExperienceService jobseekerexperienceservice;
	
	@RequestMapping(value = "/getallseekerexperience")
	public List<JobSeekerExperience> getAllSeekerExperience() {
		return jobseekerexperienceservice.getAllSeekerExperience();
	}
	
	@RequestMapping(value = "/addjobseekerexperience", method = RequestMethod.POST)
	public boolean addJobSeekerExperience(@RequestBody JobSeekerExperience experience) {
		return jobseekerexperienceservice.addJobSeekerExperience(experience);
	}

}
