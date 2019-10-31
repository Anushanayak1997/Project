package com.sony.dao;

import java.util.List;
import com.sony.model.entity.JobSeekerEducationType;

public interface JobSeekerEducationTypeDAO {
	Integer addJobSeekerEducationType(JobSeekerEducationType educationType);

	List<JobSeekerEducationType> getAllSeekerEducationType();
}
