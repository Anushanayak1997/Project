package com.sony.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.dao.CompanyDAO;
import com.sony.dao.JobPostDAO;

import com.sony.dao.SkillSetDAO;
import com.sony.model.dto.JobPostDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.SkillSet;

@Service
public class JobPostServiceImpl implements JobPostService {

//	private static final Logger logger = LoggerFactory.getLogger(JobSeekerEducationDAOImpl.class);

	@Autowired
	private JobPostDAO jobpostdao;

	@Autowired
	private CompanyDAO companydao;

	@Autowired
	private SkillSetDAO skilldao;

	@Autowired
	HttpSession httpsession;

	public List<JobPostDTO> getJobsByCompId(int companyid) {
		Company company = companydao.getCompanyById(companyid);
		return jobpostdao.getJobsByCompId(company);
	}

	public Integer addJobPost(JobPostDTO jobpostdto) {
		Company company = companydao.getCompanyById(jobpostdto.getCompanyId());
		Set<SkillSet> skillset = new HashSet<SkillSet>();

	 Iterator<SkillSet> iterator= skillset.iterator();
	//	Iterator<SkillSet> iterator = jobpostdto.getSkillset().iterator();
		while (iterator.hasNext()) {
			SkillSet skill = iterator.next();
			skillset.add(skilldao.getSkillById(skill.getSkillName()));
		}
		JobPost jobpost = new JobPost(jobpostdto.getJobPostId(), jobpostdto.getJobTitle(),
				jobpostdto.getJobDescription(), jobpostdto.isActive(), jobpostdto.getExperience(),
				jobpostdto.getNoOfApplicants(), jobpostdto.getPostDate(), jobpostdto.getNoOfVacancies(),
				jobpostdto.getStreetAddress(), jobpostdto.getCity(), jobpostdto.getState(), company, skillset);

		// jobpost.setSkillset(skillset);
		Integer jobpostid = jobpostdao.addJobPost(jobpost);
		if (jobpostid != null)
			return jobpostid;
		else {
			return null;
		}
	}

	public JobPostDTO getJobById(Integer jobpostid) {
		return jobpostdao.getJobById(jobpostid);
	}

	public List<JobPostDTO> getAllJobs() {
		return jobpostdao.getAllJobs();
	}
public void editJobPost(JobPost jobpost) {
		jobpostdao.editJobPost(jobpost);
	}

public void deleteJobPost(int jobpostid) {
	 jobpostdao.deleteJobPost(jobpostid);
	
}
}
