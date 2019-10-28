package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sony.model.entity.JobSeekerEducationType;
import com.sony.model.service.JobSeekerEducationTypeService;

@RestController
public class JobSeekerEducationTypeController {
	@Autowired
	JobSeekerEducationTypeService jobseekereducationTypeservice;
	
	@RequestMapping(value = "/getallseekereducationtype")
	public List<JobSeekerEducationType> getAllSeekerEducationType() {
		return jobseekereducationTypeservice.getAllSeekerEducationType();
	}
	
	@RequestMapping(value = "/addjobseekereducationtype", method = RequestMethod.POST)
	public boolean addJobSeekerEducationType(@RequestBody JobSeekerEducationType educationType) {
		return jobseekereducationTypeservice.addJobSeekerEducationType(educationType);
	}
	
}
