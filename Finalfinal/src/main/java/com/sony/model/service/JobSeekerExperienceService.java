package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerExperience;

public interface JobSeekerExperienceService {



	boolean addJobSeekerExperience(JobSeekerExperience experience);

	List<JobSeekerExperience> getAllSeekerExperience();



}
