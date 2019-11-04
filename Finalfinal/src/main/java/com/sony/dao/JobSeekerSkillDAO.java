package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SeekerSkillDTO;
import com.sony.model.entity.JobSeekerSkills;
 
public interface JobSeekerSkillDAO {

	public Integer addJobSeekerSkill(JobSeekerSkills skill);

	public List<JobSeekerSkills> getAllSkills();

	public List<SeekerSkillDTO> getSeekerSkillById(int userId);

	public void editSeekerSkill(JobSeekerSkills skills);

}
