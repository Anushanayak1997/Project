package com.sony.model.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;


@Entity
@Table(name = "JOBPOST_SKILL")
public class JobPostSkill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "jobpostskill_sequence")
    @SequenceGenerator(name = "jobpostskill_sequence", sequenceName = "JOBPOSTSKILL_ID_SEQ")
	@Column(name = "jobpostskill_id")
	private int jobpostSkillId;
	
	private JobPost jobpost;
	
	private SkillSet skillset;
	
	@Column(name = "skill_level")
	private int skilllevel;

	public int getSkill_level() {
		return skilllevel;
	}

	public void setSkill_level(int skill_level) {
		this.skilllevel = skill_level;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_post_id") 
	public JobPost getJobpost() {
		return jobpost;
	}

	public void setJobpost(JobPost jobpost) {
		this.jobpost = jobpost;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id") 
	public SkillSet getSkillset() {
		return skillset;
	}

	public void setSkillset(SkillSet skillset) {
		this.skillset = skillset;
	}

	public int getSkilllevel() {
		return skilllevel;
	}

	public void setSkilllevel(int skilllevel) {
		this.skilllevel = skilllevel;
	}

	public int getJobpostSkillId() {
		return jobpostSkillId;
	}

	public void setJobpostSkillId(int jobpostSkillId) {
		this.jobpostSkillId = jobpostSkillId;
	}

}
