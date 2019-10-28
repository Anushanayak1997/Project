package com.sony.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.SpecialisationDAO;
import com.sony.model.entity.Specialisation;



@Service
public class SpecialisationServiceImpl implements SpecialisationService {
	
	@Autowired
	SpecialisationDAO specialisationdao;
	

	

	public boolean addSpecialisation(Specialisation specialisationset) {
		if (specialisationdao.addSpecialisation(specialisationset)!= null)
			return true;
		return false;
	}


	public List<Specialisation> getAllSpecialisations() {
		return specialisationdao.getAllSpecialisations();
	}

}
