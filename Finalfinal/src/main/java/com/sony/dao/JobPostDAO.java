package com.sony.dao;

import java.util.List;

import com.sony.model.entity.CompanyEntity;
import com.sony.model.entity.JobPostEntity;

public interface JobPostDAO {

	
	public List<JobPostEntity> getJobsByCompId(CompanyEntity company);

	public Integer addJobPost(JobPostEntity jobpostentity);
}
