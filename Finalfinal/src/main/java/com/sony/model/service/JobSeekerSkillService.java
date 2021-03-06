package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.SeekerSkillDTO;
import com.sony.model.entity.JobSeekerSkills;


public interface JobSeekerSkillService {
	public Integer addJobSeekerSkill(SeekerSkillDTO skills);

	public List<SeekerSkillDTO> getAllSkills();

	public List<SeekerSkillDTO> getSeekerSkillById(int userId);

	public void editSeekerSkill(JobSeekerSkills skills);

}
