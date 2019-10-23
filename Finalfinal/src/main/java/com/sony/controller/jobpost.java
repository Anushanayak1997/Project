package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobPostEntity;
import com.sony.model.entity.UserEntity;
import com.sony.model.service.JobPostService;
@RestController
public class jobpost {
	    
	@Autowired
	JobPostService jobpostservice;

	@RequestMapping(value = "/getalljobpost")
	public List<JobPostEntity> getAllJobs() {
		return jobpostservice.getAllJobs();
	}
	
	@RequestMapping(value = "/addjobs", method = RequestMethod.POST)
	public boolean addJobPost(@RequestBody JobPostEntity jobpostentity) {
		return jobpostservice.addJobPost(jobpostentity);
	}
}
