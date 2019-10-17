package com.sony.project.services;

import java.util.Iterator;
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

	public List<JobPostEntity> getAllJobPost() {
		return jobposts;
	}

	public void addJobPost(JobPostEntity jobpostentity) {
		int index;
		jobposts.add(jobpostentity);
		index = jobposts.indexOf(jobpostentity);
		jobposts.get(index).setJobPostId(index);
	}

	public JobPostEntity getJobPost(int id) {
		Iterator<JobPostEntity> iterator = jobposts.iterator();
		while (iterator.hasNext()) {
			JobPostEntity jpentity = iterator.next();
			if (jpentity.getJobPostId() == id) {
				return jpentity;
			}
		}
		return null;
	}

	public void updateProduct(int id, JobPostEntity jpentity) {
		Iterator<JobPostEntity> iterator = jobposts.iterator();
		while (iterator.hasNext()) {
			JobPostEntity jobpentity = iterator.next();
			if (jobpentity.getJobPostId() == id) {
				jobposts.set(jobposts.indexOf(jobpentity), jpentity);
			}
		}
	}

	public void deleteProduct(int id) {
		Iterator<JobPostEntity> iterator = jobposts.iterator();
		while (iterator.hasNext()) {
			JobPostEntity jpentity = iterator.next();
			if (jpentity .getJobPostId() == id) {
				jobposts.remove(jobposts.indexOf(jpentity ));
				break;
			}
		}
	}
}
