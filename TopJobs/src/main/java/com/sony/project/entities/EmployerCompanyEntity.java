package com.sony.project.entities;

public class EmployerCompanyEntity {

	private int userId;
	private int companyId;

	public EmployerCompanyEntity() {
		// TODO Auto-generated constructor stub
	}

	public EmployerCompanyEntity(int userId, int companyId) {
		this.userId = userId;
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
