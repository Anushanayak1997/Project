package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.entity.JobSeekerExperience;

public interface JobSeekerExperienceService {

	public Integer addJobSeekerExperience(SeekerExperienceDTO experience);

	public List<SeekerExperienceDTO> getAllSeekerExperience();

	public List<SeekerExperienceDTO> getExperienceById(int userId);

	public void editSeekerExperience(JobSeekerExperience jobseekerexperience);

	public void deleteSeekerExperience(int experienceId);

}
