package ems.services;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface MultipartServices {

	
	public boolean uploadEmployeeImages(List<CommonsMultipartFile> list,int empid);
	public void deleteFile(List<String> names);
}
