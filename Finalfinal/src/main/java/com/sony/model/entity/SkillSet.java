package com.sony.model.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sony.model.dto.SkillSetDTO;

@Entity
@Table(name = "skillset")
public class SkillSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_sequence")
	@SequenceGenerator(name = "skill_sequence", sequenceName = "SKILL_ID_SEQ")
	@Column(name = "skill_id")
	private int skillId;

	@Column(name = "skill_name")
	private String skillName;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "skillset")
	private Set<JobSeekerSkills> user = new HashSet<JobSeekerSkills>();
	
	public SkillSet() {
		// TODO Auto-generated constructor stub
	}
	
	public SkillSet(SkillSetDTO skillsetdto) {
		this.skillId = skillsetdto.getSkillId();
		this.skillName = skillsetdto.getSkillName();
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

	public Set<JobSeekerSkills> getUser() {
		return user;
	}

	public void setUser(Set<JobSeekerSkills> user) {
		this.user = user;
	}
}
