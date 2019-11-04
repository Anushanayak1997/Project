package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.JobPost;

public interface JobPostService {

	public Integer addJobPost(JobPostDTO jobpostdto);

	public List<JobPost> getJobsByCompId(int companyId);
	
	public JobPost getJobById(Integer jobpostid);

	public List<JobPostDTO> getAllJobs();

	public void editJobPost(JobPost jobpost);

	public void deleteJobPost(int jobpostid);

}
