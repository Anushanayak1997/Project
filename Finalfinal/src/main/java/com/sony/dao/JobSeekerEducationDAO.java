package com.sony.dao;

import java.util.List;

import com.sony.model.dto.EducationDTO;
import com.sony.model.entity.JobSeekerEducation;

 
public interface JobSeekerEducationDAO {
 

	Integer addJobSeekerEducation(JobSeekerEducation education);

	List<EducationDTO> getAllSeekerEducation();

	List<JobSeekerEducation> getSeekerEducationById(int userId);

	void editSeekerEducation(JobSeekerEducation jobSeekerEducation);

	

	void deleteSeekerEducation(int educationId);
}
