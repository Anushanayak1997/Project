package com.sony.model.service;

import java.util.List;

import com.sony.model.entity.Specialisation;;


public interface SpecialisationService {
	public boolean addSpecialisation(Specialisation specialisations);

	public List<Specialisation> getAllSpecialisations();

}