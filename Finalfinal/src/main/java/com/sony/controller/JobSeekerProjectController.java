package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.entity.JobSeekerProject;
import com.sony.model.service.JobSeekerProjectService;

@RestController
public class JobSeekerProjectController {

	@Autowired
	public JobSeekerProjectService jobseekerprojectservice;
	
	@RequestMapping(value = "/getallseekerprojects")
	public List<JobSeekerProject> getAllProjects() {
		return jobseekerprojectservice.getAllProject();
	}
	
	@RequestMapping(value = "/addjobseekerproject", method = RequestMethod.POST)
	public boolean addJobSeekerProject(@RequestBody JobSeekerProject projects) {
		return jobseekerprojectservice.addJobSeekerProject(projects);
	}
}
