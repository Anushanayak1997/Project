package com.sony.dao;

import java.util.List;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.UserDetail;

public interface CompanyDAO {

	public Integer addCompany(Company company);
	
	public Company getCompanyById(int companyId);
	
	public List<CompanyDTO> getAllCompany();
	
	public int updateProfileImage(String profileImage, int companyId);

	public UserDetail getUserById(int userId); 
}
