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
	public List<JobPostDTO> getJobsByCompId(@PathVariable int companyId) {
		return jobpostservice.getJobsByCompId(companyId);
	}
	
	@RequestMapping(value = "/getjobsbyid/{jobpostId}")
	public JobPostDTO getJobById(@PathVariable int jobpostId) {
		return jobpostservice.getJobById(jobpostId);
	}
	
	@RequestMapping(value = "/addjobpost", method = RequestMethod.POST)
	public Integer addJobPost(@RequestBody JobPostDTO jobpostdto) {
		return jobpostservice.addJobPost(jobpostdto);
	}
	
	@RequestMapping(value = "/getalljobs")
	public List<JobPostDTO> getAllJobs() {
		return jobpostservice.getAllJobs();
	}
	
	@RequestMapping(value = "/editjobpost", method = RequestMethod.PUT)
	public void editJobPost(@RequestBody JobPost jobpost) {
		jobpostservice.editJobPost(jobpost);
	}
	
	@RequestMapping(value = "/deletejobpost/{jobpostid}", method = RequestMethod.DELETE)
	public void deleteJobPost(@PathVariable int jobpostid ) {
		jobpostservice.deleteJobPost(jobpostid);
	}
}
