package com.sony.dao;

import java.util.List;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.Avatar;

public interface CompanyDAO {

	public Integer addCompany(Company company);
	
	public CompanyDTO getCompanyById(int companyId);
	
	public List<CompanyDTO> getAllCompany();

	public Integer addImage(byte[] file);

	public String getImage(int avatarId); 
}
