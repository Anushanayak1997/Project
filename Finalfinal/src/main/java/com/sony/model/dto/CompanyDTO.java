package com.sony.model.dto;

import java.io.Serializable;

import com.sony.model.entity.Company;

public class CompanyDTO implements Serializable {

	private int companyId;
	private String companyName;
	private String companyDescription;
	private String establishmentDate;
	private String websiteUrl;
	private String headquarter;
	private String specialities;
	private String industry;
	private String type;
	private byte[] image;
	private String compimage;
	private int userId;

	public CompanyDTO() {
	}

	public CompanyDTO(int companyId, String companyName, String companyDescription, String establishmentDate,
			String websiteUrl, String headquarter, String specialities, String industry, byte[] image, int userId) {
		this.companyId = companyId; 
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.establishmentDate = establishmentDate; 
		this.websiteUrl = websiteUrl;
		this.headquarter = headquarter;
		this.specialities = specialities;
		this.industry = industry;
		this.type = type;
		this.image = image;
		this.userId = userId;
	}

	public CompanyDTO(int companyId, String companyName, String companyDescription, String establishmentDate,
			String websiteUrl, String headquarter, String specialities, String industry, String type, String compimage) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.establishmentDate = establishmentDate;
		this.websiteUrl = websiteUrl;
		this.headquarter = headquarter;
		this.specialities = specialities;
		this.industry = industry;
		this.type = type;
		this.compimage = compimage;
	}
	
	public CompanyDTO(Company company) {
		this.companyId = company.getCompanyId();
		this.companyName = company.getCompanyName();
		this.companyDescription = company.getCompanyDescription();
		this.establishmentDate = company.getEstablishmentDate();
		this.websiteUrl = company.getWebsiteUrl();
		this.headquarter = company.getHeadquarter();
		this.specialities = company.getSpecialities();
		this.industry = company.getIndustry();
		this.type = company.getType();
	}

	public Company getCompany(CompanyDTO companydto) {
		Company company = new Company(companydto.getCompanyId(), companydto.getCompanyName(),
				companydto.getCompanyDescription(), companydto.getEstablishmentDate(), companydto.getWebsiteUrl(),
				companydto.getHeadquarter(), companydto.getSpecialities(), companydto.getIndustry(),
				companydto.getType(), companydto.getImage());
		return company;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(String establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCompimage() {
		return compimage;
	}

	public void setCompimage(String compimage) {
		this.compimage = compimage;
	}

}
