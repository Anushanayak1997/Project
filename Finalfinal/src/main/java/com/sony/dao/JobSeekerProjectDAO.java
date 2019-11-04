package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerProject;

public interface JobSeekerProjectDAO {
	Integer addJobSeekerProject(JobSeekerProject project);

	List<JobSeekerProject> getAllProject();

	List<JobSeekerProject> getProjectsById(int userId);

	void editSeekerProject(JobSeekerProject jobSeekerproject);

}
