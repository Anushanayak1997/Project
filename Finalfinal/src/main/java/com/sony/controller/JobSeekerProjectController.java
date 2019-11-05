package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SeekerProjectDTO;

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
	public Integer addJobSeekerProject(@RequestBody SeekerProjectDTO projects) {
		return jobseekerprojectservice.addJobSeekerProject(projects);
	}
	
	@RequestMapping(value = "/getallseekerprojects/{userId}")
	public List<JobSeekerProject> getProjectsById(@PathVariable int userId) {
		return jobseekerprojectservice.getProjectById(userId);
	}
	
	@RequestMapping(value = "/editseekerproject", method = RequestMethod.PUT)
	public void editSeekerProject(@RequestBody JobSeekerProject jobSeekerproject) {
		jobseekerprojectservice.editSeekerProject(jobSeekerproject);
	}
	
	@RequestMapping(value = "/deleteseekerproject/{projectId}", method = RequestMethod.DELETE)
	public void deleteSeekerProject(@PathVariable int projectId ) {
		jobseekerprojectservice.deleteSeekerProject(projectId);
	}
}
