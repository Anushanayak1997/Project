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
		jobposts.add(new JobPostEntity(1, "Software Engineer", "Development", true, "2-3 years", 3, "12/23/1030", "something", 6));
		jobposts.add(new JobPostEntity(2, "Software Developer", "Software Development", true, "2-3 years", 3, "12/10/1030", "something something", 8));
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
