package com.sony.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerEducationDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.EducationDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobSeekerEducation;
import com.sony.model.entity.User;

@Service
public class JobSeekerEducationServiceImpl implements JobSeekerEducationService {

	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationServiceImpl.class);

	@Autowired
	JobSeekerEducationDAO educationdao;

	@Autowired
	UserDAO userdao;

	public Integer addJobSeekerEducation(EducationDTO education) {
		UserDTO userdto = userdao.getUserById(education.getUserId());
		User user = new User(userdto);
		logger.info("User" + user.getUserID());
		JobSeekerEducation seekereducation = new JobSeekerEducation(education.getJobSeekerEducationId(),
				education.getStartingDate(), education.getEndingDate(), education.getMarksPercentages(),
				education.getEducationType(), education.getSpecialization(), user);
		Integer seekereducationId = educationdao.addJobSeekerEducation(seekereducation);
		if (seekereducationId != null)
			return seekereducationId;
		return null;
	}

	public List<JobSeekerEducation> getAllSeekerEducation() {
		return educationdao.getAllSeekerEducation();
	}

	public List<JobSeekerEducation> getSeekerEducationById(int userId) {
		return educationdao.getSeekerEducationById(userId);
	}

	public void editseekereducation(JobSeekerEducation jobSeekerEducation) {

		educationdao.editSeekerEducation(jobSeekerEducation);

	}

	

	public void deleteSeekerEducation(int educationId) {
		educationdao.deleteSeekerEducation(educationId);
		
	}

}
