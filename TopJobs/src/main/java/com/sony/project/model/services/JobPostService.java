package com.sony.project.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sony.project.entities.JobPostEntity;

@Service
public class JobPostService {

	List<JobPostEntity> jobposts;
	
	public JobPostService() {
		jobposts = new LinkedList<JobPostEntity>();
	}
	
	public List<JobPostEntity> getJobPost() {
		return jobposts;
	}
	
	public void addJobPost(JobPostEntity jobpostentity) {
		int index;
		jobposts.add(jobpostentity);
		index = jobposts.indexOf(jobpostentity);
		jobposts.get(index).setJobPostId(index);
	}
}
