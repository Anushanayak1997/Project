package com.sony.model.dto;

import java.io.Serializable;

public class SkillSetDTO implements Serializable{
	
	private int skillId;
	
	private String skillName;

	public SkillSetDTO(int skillId, String skillName) {

		this.skillId = skillId;
		this.skillName = skillName;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
