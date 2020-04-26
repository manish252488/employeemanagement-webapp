package ems.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ems.services.MultipartServices;

@Controller
public class MultipartController{
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	MultipartServices multi=(MultipartServices)ctx.getBean("multipartdao");

	@PostMapping("/uploadempdet")
	public ModelAndView UploadEmployeeImages(@RequestParam int empid,@RequestParam CommonsMultipartFile image,@RequestParam CommonsMultipartFile adhar,@RequestParam CommonsMultipartFile pan,HttpServletResponse res){
		List<CommonsMultipartFile> list=new ArrayList<CommonsMultipartFile>();
		list.add(0,image);
		list.add(1,adhar);
		list.add(2,pan);
		ModelAndView mav=new ModelAndView();
		if(multi.uploadEmployeeImages(list,empid))
			mav.setViewName("index");
		else
			mav.setViewName("uploadfile");
		return mav;
		
		}

}
