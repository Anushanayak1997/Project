package com.sony.dao;

import java.util.List;

import com.sony.model.entity.JobSeekerEducation;

 
public interface JobSeekerEducationDAO {
 

	Integer addJobSeekerEducation(JobSeekerEducation education);

	List<JobSeekerEducation> getAllSeekerEducation();

	List<JobSeekerEducation> getSeekerEducationById(int userId);

	void editSeekerEducation(JobSeekerEducation jobSeekerEducation);
}
