package com.sony.dao;

import java.util.List;


import com.sony.model.entity.Specialisation;

public interface SpecialisationDAO {
	public Integer addSpecialisation(Specialisation Specialisationset);

	public List<Specialisation> getAllSpecialisations();
}
