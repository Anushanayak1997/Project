package com.sony.project.services;

import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.stereotype.Service;
import com.sony.project.entities.CompanyDetails;

@Service
public class CompanyServices {
	LinkedList<CompanyDetails> companyService = new LinkedList<CompanyDetails>();

	public void addCompanyDetails(CompanyDetails companyDetails) {
		companyService.add(companyDetails);
		int index = companyService.indexOf(companyDetails);
		companyService.get(index).setCompanyId(index);
		// System.out.println(index);

	}

	public LinkedList<CompanyDetails> getCompany() {

		return companyService;

	}

	public CompanyDetails getCompanyDetails(int id) {
		Iterator<CompanyDetails> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetails companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				return companyDetails;
			}
		}
		return null;
	}

	public void updateCompanyDetails(int id, CompanyDetails obj) {
		Iterator<CompanyDetails> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetails companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				int index = companyService.indexOf(companyDetails);
				companyService.set(index, obj);
			}
		}
	}

	public void deleteCompanyDetails(int id) {
		Iterator<CompanyDetails> i = companyService.iterator();
		while (i.hasNext()) {
			CompanyDetails companyDetails = i.next();
			if (companyDetails.getCompanyId() == id) {
				int index = companyService.indexOf(companyService);
companyService.remove(index);
			}
		}
	}


}
