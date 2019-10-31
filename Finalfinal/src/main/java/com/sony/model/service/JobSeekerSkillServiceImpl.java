package com.sony.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerSkillDAO;
import com.sony.dao.UserDAO;
import com.sony.model.dto.SeekerSkillDTO;

import com.sony.model.entity.JobSeekerSkills;

import com.sony.model.entity.User;

@Service
public class JobSeekerSkillServiceImpl implements JobSeekerSkillService {
	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationServiceImpl.class);

	@Autowired
	JobSeekerSkillDAO jobseekerskilldao;

	@Autowired
	UserDAO userdao;

	public Integer addJobSeekerSkill(SeekerSkillDTO skill) {
		User user = userdao.getUserById(skill.getUserId());
		logger.info("User" + user.getUserID());
		JobSeekerSkills seekerskill = new JobSeekerSkills(skill.getJobSeekerSkillId(), skill.getCertificateName(),
				skill.getIssuedDate(),skill.getSkillLevel(), user);
		Integer seekerskillId = jobseekerskilldao.addJobSeekerSkill(seekerskill);
		if (seekerskillId != null)
			return seekerskillId;
		return null;
	}

	public List<JobSeekerSkills> getAllSkills() {
		return jobseekerskilldao.getAllSkills();
	}

}
