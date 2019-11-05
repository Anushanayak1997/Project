package com.sony.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
import com.sony.model.entity.JobPost;
import com.sony.model.entity.User;
import com.sony.model.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@RequestMapping(value = "/getallcompany")
	public List<CompanyDTO> getAllCompany() {
		return companyservice.getAllCompany(); 
	}
	
	@RequestMapping(value = "/getcompbyid/{companyId}")
	public Company getUsersById(@PathVariable int companyId) {
		return companyservice.getCompanyById(companyId);
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody CompanyDTO companydto) {
		return(companyservice.addCompany(companydto));
	}
	
	@RequestMapping(value = "/setcompanyid", method = RequestMethod.POST) 
	public Integer setCompanyIdSession(@RequestBody CompanyDTO companydto) {
		return (companyservice.setCompanyIdSession(companydto));
	}
	
	
	
	
	
	@RequestMapping(value = "/uploadImage/{companyId}", method = RequestMethod.POST)  
    public int handleFileUpload(@PathVariable int companyId , @RequestParam("file") MultipartFile file, HttpSession session) { 
		logger.info("Fileeee" + file.getName() + "Useriddddd" + companyId);
        return companyservice.store(file, companyId, session);          
    }  
	
	@RequestMapping(value = "/download")
	public Resource getFileFromFileSystem(HttpServletResponse response) {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=1.pdf");
		response.setHeader("filename", "1.pdf");
		Resource resource = null;
		resource = new FileSystemResource("D:/1.pdf");
		logger.info("Resource" + resource.getFilename());
		return resource;
	}
}
