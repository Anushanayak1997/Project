package com.sony.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.entity.JobSeekerExperience;
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
	public Integer addJobSeekerExperience(@RequestBody SeekerExperienceDTO experience) {
		return jobseekerexperienceservice.addJobSeekerExperience(experience);
	}
	
	@RequestMapping(value = "/getexperiencebyid/{userId}")
	public List<JobSeekerExperience> getExperiencesById(@PathVariable int userId) {
		return jobseekerexperienceservice.getExperienceById(userId);
	}
	
	@RequestMapping(value = "/editseekerexperience", method = RequestMethod.PUT)
	public void editSeekerExperience(@RequestBody JobSeekerExperience jobseekerexperience) {
		jobseekerexperienceservice.editSeekerExperience(jobseekerexperience);
	}


	@RequestMapping(value = "/deleteseekerexperience/{experienceId}", method = RequestMethod.DELETE)
	public void deleteSeekerExperience(@PathVariable int experienceId ) {
		jobseekerexperienceservice.deleteSeekerExperience(experienceId);
	}
}
