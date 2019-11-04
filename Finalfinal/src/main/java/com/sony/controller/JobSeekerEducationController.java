package com.sony.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.JobSeekerEducation;

import com.sony.model.service.JobSeekerEducationService;
import com.sony.model.service.JobSeekerEducationServiceImpl;

@RestController
public class JobSeekerEducationController {
	
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationController.class);
	
	@Autowired
	JobSeekerEducationService jobseekereducationservice;
	
	@RequestMapping(value = "/getallseekereducation")
	public List<JobSeekerEducation> getAllSeekerEducation() {
		return jobseekereducationservice.getAllSeekerEducation();
	}
	
	@RequestMapping(value = "/addjobseekereducation", method = RequestMethod.POST)
	public Integer addJobSeekerEducation(@RequestBody EducationDTO education) {
		return jobseekereducationservice.addJobSeekerEducation(education);
	}
	
	@RequestMapping(value = "/getseekereducationbyid/{userId}")
	public List<JobSeekerEducation> getSeekerEducationById(@PathVariable int userId) {
		if(jobseekereducationservice.getSeekerEducationById(userId) != null) {
			return jobseekereducationservice.getSeekerEducationById(userId);
		}
		else {
			return null;
		}
	}
	
	@RequestMapping(value = "/editseekereducation", method = RequestMethod.PUT)
	public void editSeekerEducation(@RequestBody JobSeekerEducation jobSeekerEducation) {
		jobseekereducationservice.editseekereducation(jobSeekerEducation);
	}
}
