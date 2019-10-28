package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_project")
public class JobSeekerProject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "job_seeker_project_sequence")
    @SequenceGenerator(name = "job_seeker_project_sequence", sequenceName = "JOB_SEEKER_PROJECT_ID_SEQ")
	@Column(name = "job_seeker_PROJECT_id")
	private int jobSeekerProjectId;
	
    @Column(name="title")
	private String title;
     
    @Column(name="description")
	private String description;
    
    @Column(name="role")
	private String role;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
