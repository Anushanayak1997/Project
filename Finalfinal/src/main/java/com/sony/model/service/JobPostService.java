package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobPostEntity;

public interface JobPostService {


	boolean addJobPost(JobPostEntity jobpostentity);

	List<JobPostEntity> getAllJobs();

}
