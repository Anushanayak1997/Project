package com.sony.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.project.entities.JobPostEntity;
import com.sony.project.services.JobPostService;

@RestController
public class JobPost {

	@Autowired
	JobPostService jobpostservice;

	@RequestMapping(value = "/getjobpost")
	public List<JobPostEntity> getJobPost() {
		return jobpostservice.getJobPost();
	}

	@RequestMapping(value = "/addjobpost", method = RequestMethod.POST)
	public void addJobPost(@RequestBody JobPostEntity jobpostentity) {
			jobpostservice.addJobPost(jobpostentity);
	}
}
