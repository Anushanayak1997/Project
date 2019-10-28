package com.sony.dao;

import java.util.List;

import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;

public interface JobPostDAO {

	
	public List<JobPost> getJobsByCompId(Company company);

	public Integer addJobPost(JobPost jobpostentity);
}
