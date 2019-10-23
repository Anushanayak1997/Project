package com.sony.dao; 

import java.util.List;

import com.sony.model.entity.JobPostEntity;

public interface JobPostDAO {

	List<JobPostEntity> getAllJobs();

	boolean addJobPost(JobPostEntity jobpostentity);
}
