package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerExperience;

public interface JobSeekerExperienceDAO {
	
	Integer addJobSeekerExperience(JobSeekerExperience experience);

	List<JobSeekerExperience> getAllSeekerExperience();

	 

}
