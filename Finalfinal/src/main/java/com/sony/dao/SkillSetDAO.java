package com.sony.dao;

import java.util.List;

import com.sony.model.entity.SkillSet;

public interface SkillSetDAO {

	public Integer addSkillSet(SkillSet skillset);

	public List<SkillSet> getAllSkills();

	public SkillSet getSkillById(String skillname);
}
