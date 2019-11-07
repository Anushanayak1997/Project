package com.sony.model.dto;

import java.io.Serializable;



public class UserDTO implements Serializable {

	private int userID;
	private String password;
	private String firstName;
	private String lastName;
	private String emailID;
	private String contactNumber;
	private String userType;
	private byte[] image;
	private String userimage;
	private byte[] resume;
	private String userresume;
	
	public UserDTO() {
		
	}
	
	public UserDTO(int userID, String password, String firstName, String lastName, String emailID, String contactNumber,
			String userType) {
		super();
		this.userID = userID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.contactNumber = contactNumber;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getUserimage() {
		return userimage;
	}

	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public String getUserresume() {
		return userresume;
	}

	public void setUserresume(String userresume) {
		this.userresume = userresume;
	}

}
