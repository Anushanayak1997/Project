package com.sony.dao;

import java.util.List; 

import com.sony.model.entity.JobSeekerProject;

public interface JobSeekerProjectDAO {

	public Integer addJobSeekerProject(JobSeekerProject jobseekerproject);

	public List<JobSeekerProject> getAllProject();
}
