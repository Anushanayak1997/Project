package com.sony.dao; 

import java.util.List;
     
import com.sony.model.entity.JobPostEntity;

public interface JobPostDAO {

	public List<JobPostEntity> getAllJobs();

	public boolean addJobPost(JobPostEntity jobpostentity);
}
