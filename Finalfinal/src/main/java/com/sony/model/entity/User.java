package com.sony.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sony.model.dto.UserDTO;

@Entity
@Table(name = "USER_REGISTER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "USER_ID_SEQ")
	@Column(name = "user_id")
	private int userID;

	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email_id")
	private String emailID;

	@Column(name = "contact_no")
	private String contactNumber;

	@Column(name = "user_type")
	private String userType;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<JobSeekerSkills> skillset = new HashSet<JobSeekerSkills>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<SeekerJobPostStatus> seekerjobpost = new HashSet<SeekerJobPostStatus>();

	public User() {
	}

	public User(UserDTO userdto) {
		this.userID = userdto.getUserID();
		this.firstName = userdto.getFirstName();
		this.lastName = userdto.getLastName();
		this.emailID = userdto.getEmailID();
		this.contactNumber = userdto.getContactNumber();
		this.userType = userdto.getContactNumber();
	}

	public Set<JobSeekerSkills> getSkillset() {
		return skillset;
	}

	public void setSkillset(Set<JobSeekerSkills> skillset) {
		this.skillset = skillset;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Set<SeekerJobPostStatus> getSeekerjobpost() {
		return seekerjobpost;
	}

	public void setSeekerjobpost(Set<SeekerJobPostStatus> seekerjobpost) {
		this.seekerjobpost = seekerjobpost;
	}

}
