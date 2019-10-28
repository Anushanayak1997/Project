package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerProject;


public interface JobSeekerProjectService {
	public boolean addJobSeekerProject(JobSeekerProject jobseekerproject);

	public List<JobSeekerProject> getAllProject();
}
