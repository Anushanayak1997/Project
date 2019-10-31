package com.sony.model.entity;

import java.util.LinkedList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import com.sony.model.entity.JobPostEntity;

@Entity
@Table(name="COMPANY")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "company_sequence")
    @SequenceGenerator(name = "company_sequence", sequenceName = "COMPANY_ID_SEQ")
	@Column(name = "company_id")
	private int companyId; 
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_description")
	private String companyDescription;
	
	@Column(name="establishment_date")
	private String establishmentDate;
	
	@Column(name="website_url")
	private String websiteUrl;
	
	@Column(name="headquarter")
	private String headquarter;
	
	@Column(name="specialities")
	private String specialities;
	
	@Column(name="industry")
	private String industry;
	
	@Column(name="company_type")
	private String type;

	public Company() {
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

}
