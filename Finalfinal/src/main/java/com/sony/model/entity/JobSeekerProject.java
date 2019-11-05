package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "job_seeker_project")
public class JobSeekerProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "job_seeker_project_sequence")
	@SequenceGenerator(name = "job_seeker_project_sequence", sequenceName = "JOB_SEEKER_PROJECT_ID_SEQ")
	@Column(name = "job_seeker_PROJECT_id")
	private int jobSeekerProjectId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "role")
	private String role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public JobSeekerProject() {
	}
	


	public JobSeekerProject(int jobSeekerProjectId, String title, String description, String role, User user) {
		super();
		this.jobSeekerProjectId = jobSeekerProjectId;
		this.title = title;
		this.description = description;
		this.role = role;
		this.user = user;
	}



	public int getJobSeekerProjectId() {
		return jobSeekerProjectId;
	}



	public void setJobSeekerProjectId(int jobSeekerProjectId) {
		this.jobSeekerProjectId = jobSeekerProjectId;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



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
