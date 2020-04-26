package ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ems.model.Attendence;
import ems.services.AttendenceServices;

@Controller
@SessionAttributes(names = "empid")
public class AttendenceLogController {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	AttendenceServices attservice=(AttendenceServices)ctx.getBean("attendao");
	
	@RequestMapping("/addAttendence")
	public ModelAndView addAttendence(HttpServletRequest req,HttpServletResponse res,HttpSession s) {
		Attendence att=new Attendence();
		att.setEmpid((Integer)s.getAttribute("empid"));
		ModelAndView mav=new ModelAndView(attservice.addAttendence(att));
		return mav;
		
	}
	@RequestMapping("/completeshift")
	public ModelAndView complteShift(HttpServletRequest req,HttpServletResponse res,HttpSession s) {
		int empid=(Integer)s.getAttribute("empid");
		ModelAndView mav=new ModelAndView(attservice.completeShift(empid));
		return mav;
		
	}
}
