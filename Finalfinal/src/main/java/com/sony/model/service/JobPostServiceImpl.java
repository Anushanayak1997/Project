package com.sony.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobPostDAO;
import com.sony.model.entity.JobPostEntity;

@Service
public class JobPostServiceImpl implements JobPostService {

	// @Autowired   
	public JobPostDAO jobpostdao;

	@Autowired
	HttpSession httpsession;

	public List<JobPostEntity> getAllJobs() {
		return jobpostdao.getAllJobs();
	}

	public boolean addJobPost(JobPostEntity jobpostentity) {

//		Integer jobpostId = jobpostdao.addJobPost(jobpostentity);
//		if(jobpostId != null) {  
//			httpsession.setAttribute("jobpostid", jobpostId);
//			return true;
//		}
		 return jobpostdao.addJobPost(jobpostentity);
	//	return false;
	}

}
