package com.sony.model.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;


public interface CompanyService {

	public Integer addCompany(CompanyDTO companydto);
	
	public List<CompanyDTO> getAllCompany();
	
	public Integer setCompanyIdSession(CompanyDTO companydto);

	public CompanyDTO getCompanyById(int companyId);
	
	// public int store(MultipartFile file, int companyId , HttpSession session); 
	
	public Integer addImage(byte[] file);

	public String getImage(int avatarId);

}
