package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.SkillSet;

public interface SkillSetService {

	public boolean addSkillSet(SkillSet skillset);

	public List<SkillSet> getAllSkills();
	
	public SkillSet getSkillById(int skillId);
}
