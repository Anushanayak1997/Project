package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.entity.JobSeekerExperience;

public interface JobSeekerExperienceService {

	Integer addJobSeekerExperience(SeekerExperienceDTO experience);

	List<JobSeekerExperience> getAllSeekerExperience();

}
