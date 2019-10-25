package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobPost;

public interface JobPostService {


	public boolean addJobPost(JobPost jobpostentity);



	public List<JobPost> getJobsByCompId();

}
