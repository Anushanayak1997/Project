package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.JobPost;

import com.sony.model.service.JobPostService;
@RestController
public class JobPostController {
	      
	@Autowired
	JobPostService jobpostservice;

	@RequestMapping(value = "/getjobsbycompid/{companyId}")
	public List<JobPost> getJobsByCompId(@PathVariable int companyId) {
		return jobpostservice.getJobsByCompId(companyId);
	}
	
	@RequestMapping(value = "/addjobpost", method = RequestMethod.POST)
	public Integer addJobPost(@RequestBody JobPostDTO jobpostdto) {
		return jobpostservice.addJobPost(jobpostdto);
	}
	
	@RequestMapping(value = "/getalljobs")
	public List<JobPost> getAllJobs() {
		return jobpostservice.getAllJobs();
	}
}
