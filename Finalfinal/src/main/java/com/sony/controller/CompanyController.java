package com.sony.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sony.model.dto.CompanyDTO;
import com.sony.model.entity.Company;
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
	public CompanyDTO getUsersById(@PathVariable int companyId) {
		return companyservice.getCompanyById(companyId);
	}

	@RequestMapping(value = "/addcompanydetails", method = RequestMethod.POST)
	public Integer addCompany(@RequestBody CompanyDTO companydto) {
		return (companyservice.addCompany(companydto));
	}

	@RequestMapping(value = "/setcompanyid", method = RequestMethod.POST)
	public Integer setCompanyIdSession(@RequestBody CompanyDTO companydto) {
		return (companyservice.setCompanyIdSession(companydto));
	}

	// --------------------------------------------UploadFile--------------------------------------------------------------//

//	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
//	public Integer uploadImage2(@RequestBody String imageValue) {
//		try {
//			// This will decode the String which is encoded by using Base64
//			// class
//			byte[] imageByte = Base64.getDecoder().decode(imageValue);
//			return companyservice.addImage(imageByte);
//		} catch (Exception e) {
//			return -1;
//		}
//	}
//	
//	@RequestMapping(value = "/download/{avatarId}")
//	public Map<String, String> getImage(@PathVariable int avatarId){
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("Image", companyservice.getImage(avatarId));
//		return map;	
//	}
}
