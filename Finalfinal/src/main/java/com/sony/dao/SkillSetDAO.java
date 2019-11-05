package com.sony.dao;

import java.util.List;

import com.sony.model.dto.SkillSetDTO;
import com.sony.model.entity.SkillSet;

public interface SkillSetDAO {

	public Integer addSkillSet(SkillSet skillset);

	public List<SkillSetDTO> getAllSkills();

	public SkillSet getSkillById(String skillname);
}
