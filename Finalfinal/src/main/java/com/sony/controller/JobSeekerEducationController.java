package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobSeekerEducation;

import com.sony.model.service.JobSeekerEducationService;

@RestController
public class JobSeekerEducationController {
	
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

}
