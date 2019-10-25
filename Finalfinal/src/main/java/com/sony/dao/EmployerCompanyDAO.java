package com.sony.dao;

import com.sony.model.entity.EmployerCompany;

public interface EmployerCompanyDAO {

	public Integer addEmployerCompany(EmployerCompany employercompany);
	
	public Integer getCompanyId(Integer UserId);
}
