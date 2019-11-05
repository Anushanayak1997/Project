package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.SkillSetDAO;
import com.sony.model.dto.SkillSetDTO;
import com.sony.model.entity.SkillSet;

@Service
public class SkillSetServiceImpl implements SkillSetService{
	
	@Autowired
	SkillSetDAO skillsetdao;

	public boolean addSkillSet(SkillSet skillset) {
		if(skillsetdao.addSkillSet(skillset) != null)
			return true;
		return false;
	}

	public List<SkillSetDTO> getAllSkills() {
		return skillsetdao.getAllSkills();
	}
	
	public SkillSet getSkillById(String skillname) {
		return skillsetdao.getSkillById(skillname);
	}

}
