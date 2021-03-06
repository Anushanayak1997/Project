package com.sony.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerProjectDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.SeekerProjectDTO;
import com.sony.model.dto.UserDTO;
import com.sony.model.entity.JobSeekerProject;

import com.sony.model.entity.User;

@Service
public class JobSeekerProjectServiceImpl implements JobSeekerProjectService {

	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationServiceImpl.class);

	@Autowired
	JobSeekerProjectDAO jobseekerprojectdao;

	@Autowired
	UserDAO userdao;

	public Integer addJobSeekerProject(SeekerProjectDTO jobseekerproject) {
		UserDTO userdto = userdao.getUserById(jobseekerproject.getUserId());
		User user = new User(userdto);
		logger.info("User" + user.getUserID());

		JobSeekerProject seekerproject = new JobSeekerProject(jobseekerproject.getJobSeekerProjectId(),
				jobseekerproject.getTitle(), jobseekerproject.getDescription(), jobseekerproject.getRole(), user);
		Integer seekerprojectId = jobseekerprojectdao.addJobSeekerProject(seekerproject);
		if (seekerprojectId != null)
			return seekerprojectId;
		return null;
	}

	public List<SeekerProjectDTO> getAllProject() {
		return jobseekerprojectdao.getAllProject();
	}

	public List<SeekerProjectDTO> getProjectById(int userId) {
		return jobseekerprojectdao.getProjectsById(userId);
	}

	public void editSeekerProject(JobSeekerProject jobSeekerproject) {
	jobseekerprojectdao.editSeekerProject(jobSeekerproject);
		
	}

	public void deleteSeekerProject(int projectId) {
		jobseekerprojectdao.deleteSeekerProject(projectId);
		
	}

}
