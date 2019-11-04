package com.sony.dao;

import java.util.List;

import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;

public interface JobPostDAO {

	
	public List<JobPostDTO> getJobsByCompId(Company company);

	public Integer addJobPost(JobPost jobpostentity);

	public JobPost getJobById(Integer jobpostid);

	public List<JobPostDTO> getAllJobs();

	public void editJobPost(JobPost jobpost);

}
