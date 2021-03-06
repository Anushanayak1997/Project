package com.sony.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerExperienceDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.SeekerExperienceDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobSeekerExperience;
import com.sony.model.entity.User;

@Service
public class JobSeekerExperienceServiceImpl implements JobSeekerExperienceService {

	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationServiceImpl.class);

	@Autowired
	JobSeekerExperienceDAO experiencedao;

	@Autowired
	UserDAO userdao;

	public Integer addJobSeekerExperience(SeekerExperienceDTO experience) {
		UserDTO userdto = userdao.getUserById(experience.getUserId());
		User user = new User(userdto);
		logger.info("User" + user.getUserID());
		JobSeekerExperience seekerexperience = new JobSeekerExperience(experience.getJobSeekerExperienceId(),
				experience.getJobTitle(), experience.getStartDate(), experience.getEndDate(),
				experience.getJobDescription(), experience.getStreetAddress(), experience.getCity(),
				experience.getState(), user);
		logger.info("SeekerExperience" + seekerexperience);
		Integer seekerexperienceId = experiencedao.addJobSeekerExperience(seekerexperience);
		if (seekerexperienceId != null)
			return seekerexperienceId;
		return null;
	}

	public List<SeekerExperienceDTO> getAllSeekerExperience() {
		return experiencedao.getAllSeekerExperience();
	}

	public List<SeekerExperienceDTO> getExperienceById(int userId) {
		return experiencedao.getExperienceById(userId);
	}

	public void editSeekerExperience(JobSeekerExperience jobseekerexperience) {
		experiencedao.editSeekerExperience(jobseekerexperience);
		
	}

	public void deleteSeekerExperience(int experienceId) {
		experiencedao.deleteSeekerExperience(experienceId);
		
	}

}
