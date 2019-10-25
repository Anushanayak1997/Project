package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerSkills;

public interface JobSeekerSkillDAO {

	public Integer addJobSeekerSkill(JobSeekerSkills skill);

	public List<JobSeekerSkills> getAllSkills();

}
