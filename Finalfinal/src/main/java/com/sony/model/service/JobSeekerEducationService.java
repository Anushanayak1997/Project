package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobSeekerEducation;

public interface JobSeekerEducationService {

	public Integer addJobSeekerEducation(EducationDTO education);

	List<EducationDTO> getAllSeekerEducation();

	List<EducationDTO> getSeekerEducationById(int userId);

	void editseekereducation(JobSeekerEducation jobSeekerEducation);

	

	public void deleteSeekerEducation(int educationId);

}
