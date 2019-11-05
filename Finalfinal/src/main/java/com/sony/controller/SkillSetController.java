package com.sony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.dto.SkillSetDTO;
import com.sony.model.entity.SkillSet;
import com.sony.model.service.SkillSetService;

@RestController
public class SkillSetController {

	@Autowired
	private SkillSetService skillsetservice;
	
	@RequestMapping(value = "/getallskills")
	public List<SkillSetDTO> getAllSkills() {
		return skillsetservice.getAllSkills();
	}
	
	@RequestMapping(value = "/addskill", method = RequestMethod.POST)
	public boolean addSkillSet(@RequestBody SkillSet skillset) {
		return skillsetservice.addSkillSet(skillset);
	}
}
