package com.sony.model.service;

import java.util.List;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobSeekerEducation;

public interface JobSeekerEducationService {

	public Integer addJobSeekerEducation(EducationDTO education);

	List<JobSeekerEducation> getAllSeekerEducation();

	List<JobSeekerEducation> getSeekerEducationById(int userId);

	void editseekereducation(JobSeekerEducation jobSeekerEducation);

}
