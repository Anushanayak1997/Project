package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.User;

public interface JobSeekerExperienceDAO {
	
	public Integer addJobSeekerExperience(JobSeekerExperience experience);

	public List<JobSeekerExperience> getAllSeekerExperience();

	public List<JobSeekerExperience> getExperienceById(int userId);

	public void editSeekerExperience(JobSeekerExperience jobseekerexperience);

	public void deleteSeekerExperience(int experienceId);

	 

}
