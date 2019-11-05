package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerProjectDTO;
import com.sony.model.entity.JobSeekerProject;


public interface JobSeekerProjectService {
	public Integer addJobSeekerProject(SeekerProjectDTO jobseekerproject);

	public List<JobSeekerProject> getAllProject();

	public List<JobSeekerProject> getProjectById(int userId);

	public void editSeekerProject(JobSeekerProject jobSeekerproject);

	public void deleteSeekerProject(int projectId);
}
