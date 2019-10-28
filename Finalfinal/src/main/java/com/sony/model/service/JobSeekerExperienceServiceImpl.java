package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerExperienceDAO;
import com.sony.model.entity.JobSeekerExperience;

@Service
public class JobSeekerExperienceServiceImpl implements JobSeekerExperienceService {
	
	@Autowired
	JobSeekerExperienceDAO experiencedao;

	public boolean addJobSeekerExperience(JobSeekerExperience experience) {
		if (experiencedao.addJobSeekerExperience(experience) != null)
			return true;
		return false;
	}

	public List<JobSeekerExperience> getAllSeekerExperience() {
		return experiencedao.getAllSeekerExperience();
	}

}
