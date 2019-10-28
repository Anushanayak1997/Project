package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerEducationDAO;
import com.sony.model.entity.JobSeekerEducation;

@Service
public class JobSeekerEducationServiceImpl implements JobSeekerEducationService {
	
	@Autowired
	JobSeekerEducationDAO educationdao;

	public boolean addJobSeekerEducation(JobSeekerEducation education) {
		if (educationdao.addJobSeekerEducation(education) != null)
			return true;
		return false;
	}

	public List<JobSeekerEducation> getAllSeekerEducation() {
		return educationdao.getAllSeekerEducation();
	}

}
