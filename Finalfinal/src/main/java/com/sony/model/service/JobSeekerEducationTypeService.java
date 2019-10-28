package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerEducationType;


public interface JobSeekerEducationTypeService {
	boolean addJobSeekerEducationType(JobSeekerEducationType educationType);

	List<JobSeekerEducationType> getAllSeekerEducationType();
}
