package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.JobPost;

public interface JobPostService {

	public Integer addJobPost(JobPostDTO jobpostdto);

	public List<JobPost> getJobsByCompId();
	
	public JobPost getJobById(Integer jobpostid);

}
