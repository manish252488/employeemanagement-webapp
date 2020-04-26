package ems.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ems.mail.SendMail;
import ems.services.EmsUsersServices;
import ems.services.LoginServices;

@Controller
@SessionAttributes(names = {"empid","role"})
public class LoginController {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	LoginServices login=(LoginServices)ctx.getBean("logindao");
	EmsUsersServices userservice=(EmsUsersServices)ctx.getBean("userdao");
	SendMail send=(SendMail)ctx.getBean("mail");
	ModelAndView mav;
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res,ModelMap model)
	{
		int empid =Integer.parseInt(req.getParameter("empid"));
		String password=req.getParameter("password");
		String view=login.validateLogin(empid, password);
		mav=new ModelAndView(view);
		if(view.equalsIgnoreCase("adminpanel") || view.equalsIgnoreCase("employeepanel") || view.equalsIgnoreCase("changepassword")) {
		model.put("empid",empid);
		model.put("role",view);
		}
		return mav;
		
	}
	@PostMapping("/fpass")
	public ModelAndView forgotPassword(HttpServletRequest req,HttpServletResponse res)
	{
		String newpass=RandomStringUtils.randomAlphanumeric(10);
		int empid=Integer.parseInt(req.getParameter("empid"));
		if(login.forgotPassword(empid,newpass))
		mav=new ModelAndView("login.jsp");
		return mav;
	}
}
