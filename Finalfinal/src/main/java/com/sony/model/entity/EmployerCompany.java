package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emp_company")
public class EmployerCompany { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "emp_company_sequence")
    @SequenceGenerator(name = "emp_company_sequence", sequenceName = "EMP_COMPANY_ID_SEQ")
	@Column(name = "id")
	private int Id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_id")
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
