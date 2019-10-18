package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.stereotype.Service;
import com.sony.project.entities.CompanyDetailsEntity;

import com.sony.project.entities.CompanyDetailsEntity;

public class CompanyServices {
	LinkedList<CompanyDetailsEntity> companyService = new LinkedList<CompanyDetailsEntity>();

	public void addCompanyDetails(CompanyDetailsEntity companyDetails) {
		companyService.add(companyDetails);
		int index = companyService.indexOf(companyDetails);
		companyService.get(index).setCompanyId(index);
	}

	public LinkedList<CompanyDetailsEntity> getCompany() {
		return companyService;
	}

	public CompanyDetailsEntity getCompanyDetails(int id) {
		Iterator<CompanyDetailsEntity> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetailsEntity companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				return companyDetails;
			}
		}
		return null;
	}

	public void updateCompanyDetails(int id, CompanyDetailsEntity obj) {
		Iterator<CompanyDetailsEntity> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetailsEntity companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				int index = companyService.indexOf(companyDetails);
				companyService.set(index, obj);
			}
		}
	}

	public void deleteCompanyDetails(int id) {
		Iterator<CompanyDetailsEntity> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetailsEntity companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				int index = companyService.indexOf(companyService);
				companyService.remove(index);
			}
		}
	}

}
