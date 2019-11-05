package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.entity.JobSeekerExperience;


public interface JobSeekerExperienceDAO {
	
	public Integer addJobSeekerExperience(JobSeekerExperience experience);

	public List<SeekerExperienceDTO> getAllSeekerExperience();

	public List<SeekerExperienceDTO> getExperienceById(int userId);

	public void editSeekerExperience(JobSeekerExperience jobseekerexperience);

	public void deleteSeekerExperience(int experienceId);

	 

}
