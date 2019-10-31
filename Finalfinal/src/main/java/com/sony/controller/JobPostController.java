package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobPost;

import com.sony.model.service.JobPostService;
@RestController
public class JobPostController {
	      
	@Autowired
	JobPostService jobpostservice;

	@RequestMapping(value = "/getalljobs")
	public List<JobPost> getJobsByCompId() {
		return jobpostservice.getJobsByCompId();
	}
	
	@RequestMapping(value = "/addjobs", method = RequestMethod.POST)
	public boolean addJobPost(@RequestBody JobPost jobpostentity) {
		return jobpostservice.addJobPost(jobpostentity);
	}
}
