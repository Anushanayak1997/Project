package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.JobSeekerSkills;


public interface JobSeekerSkillService {
	public boolean addJobSeekerSkill(JobSeekerSkills skill);

	public List<JobSeekerSkills> getAllSkills();

}
