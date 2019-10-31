package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerProjectDAO;
import com.sony.model.entity.JobSeekerProject;
import com.sony.model.entity.JobSeekerSkills;

@Service
public class JobSeekerProjectServiceImpl implements JobSeekerProjectService {
	
	@Autowired
	JobSeekerProjectDAO jobseekerprojectdao;
	

	public boolean addJobSeekerProject(JobSeekerProject jobseekerproject) {
		if (jobseekerprojectdao.addJobSeekerProject(jobseekerproject) != null)
			return true;
		return false;
	}


	public List<JobSeekerProject> getAllProject() {
		return jobseekerprojectdao.getAllProject();
	}

}
