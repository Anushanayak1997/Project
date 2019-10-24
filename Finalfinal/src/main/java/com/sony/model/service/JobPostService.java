package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobPostEntity;

public interface JobPostService {


	public boolean addJobPost(JobPostEntity jobpostentity);

	public List<JobPostEntity> getAllJobs();

}
