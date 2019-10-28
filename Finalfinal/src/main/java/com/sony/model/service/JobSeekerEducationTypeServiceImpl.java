package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerEducationTypeDAO;
import com.sony.model.entity.JobSeekerEducationType;

@Service
public class JobSeekerEducationTypeServiceImpl implements JobSeekerEducationTypeService{
	
	
	@Autowired
	JobSeekerEducationTypeDAO jobseekereducationtypedao;

	public boolean addJobSeekerEducationType(JobSeekerEducationType educationType) {
	if(jobseekereducationtypedao.addJobSeekerEducationType(educationType)!=null)
	{
		return true;
	}
	return false;
	}
	

	public List<JobSeekerEducationType> getAllSeekerEducationType() {
		return jobseekereducationtypedao.getAllSeekerEducationType();
	}

}
