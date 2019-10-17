package com.sony.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sony.project.entities.JobPostEntity;
import com.sony.project.services.JobPostService;

@RestController
public class JobPost {

	JobPostService jobpostservice;

	@RequestMapping(value = "/getalljobpost")
	public List<JobPostEntity> getAllJobPost() {
		return jobpostservice.getAllJobPost();
	}

	@RequestMapping(value = "/getjobpost/{id}")
	public JobPostEntity getJobPost(@PathVariable int id) {
		return jobpostservice.getJobPost(id);
	}

	@RequestMapping(value = "/addjobpost", method = RequestMethod.POST)
	public void addJobPost(@RequestBody JobPostEntity jobpostentity) {
		jobpostservice.addJobPost(jobpostentity);
	}

	@RequestMapping(value = "/putjobpost/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable int id, @RequestBody JobPostEntity jpentity) {
		jobpostservice.updateProduct(id, jpentity);
	}

	@RequestMapping(value = "/deletejobpost/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		jobpostservice.deleteProduct(id);
	}
}
