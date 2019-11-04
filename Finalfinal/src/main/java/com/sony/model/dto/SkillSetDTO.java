package com.sony.model.dto;

public class SkillSetDTO {
private int skillId;
private String skillName;
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
public SkillSetDTO(int skillId, String skillName) {
	super();
	this.skillId = skillId;
	this.skillName = skillName;
}


}
