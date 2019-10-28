package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.JobSeekerSkillDAO;
import com.sony.model.entity.JobSeekerSkills;
import com.sony.model.entity.SkillSet;

@Service
public class JobSeekerSkillServiceImpl implements JobSeekerSkillService {

	@Autowired
	JobSeekerSkillDAO jobseekerskilldao;

	public boolean addJobSeekerSkill(JobSeekerSkills skill) {
		if (jobseekerskilldao.addJobSeekerSkill(skill) != null)
			return true;
		return false;
	}

	public List<JobSeekerSkills> getAllSkills() {
		return jobseekerskilldao.getAllSkills();
	}
	
	


}
