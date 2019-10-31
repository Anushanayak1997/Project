package com.sony.model.entity;

import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "skillset")
public class SkillSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_sequence")
	@SequenceGenerator(name = "skill_sequence", sequenceName = "SKILL_ID_SEQ")
	@Column(name = "skill_id")

	private int skillId;
	
	private LinkedList<JobPostSkill> jobpostskill = new LinkedList<JobPostSkill>();

	@Column(name = "skill_name")
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

	@OneToMany(mappedBy = "jobpost")
	public LinkedList<JobPostSkill> getJobpostskill() {
		return jobpostskill;
	}

	public void setJobpostskill(LinkedList<JobPostSkill> jobpostskill) {
		this.jobpostskill = jobpostskill;
	}
}
