package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerEducation;

public interface JobSeekerEducationService {

	boolean addJobSeekerEducation(JobSeekerEducation education);

	List<JobSeekerEducation> getAllSeekerEducation();

}
