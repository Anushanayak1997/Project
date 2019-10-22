package com.sony.project.services;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.project.entities.CompanyDetailsEntity;
import com.sony.project.entities.JobPostEntity;

@Service
public class JobPostService {

	// List<JobPostEntity> jobposts = new LinkedList<JobPostEntity>();
	
	@Autowired
	HttpSession httpSession;
	
	public JobPostService() {
	
	}
	
//	public List<JobPostEntity> getJobPost() {
//		return jobposts;
//	}
}
