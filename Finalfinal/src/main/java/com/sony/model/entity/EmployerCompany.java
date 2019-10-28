package com.sony.model.entity;

public class EmployerCompany {
	private int Id;
	private int userId;
	private int companyId;
	
	public EmployerCompany() {
	}

	public EmployerCompany(int userId, int companyId) {
		this.userId = userId;
		this.companyId = companyId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
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
