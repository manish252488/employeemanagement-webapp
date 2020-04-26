package ems.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ems.model.Employee;
import ems.model.EmsUsers;
import ems.services.EmsUsersServices;
@SessionAttributes(names = {"empid","role"})
@Controller
public class UserController {

	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	EmsUsersServices userservice=(EmsUsersServices)ctx.getBean("userdao");
	ModelAndView mav;
	
		@PostMapping("/updateuser")
		public ModelAndView updateUser(HttpServletRequest req,HttpServletResponse res,ModelMap model)throws IOException,ServletException
		{
			HttpSession ses=req.getSession();
			String newp=req.getParameter("newpass1");
			EmsUsers user=new EmsUsers();
			Employee emp=new Employee();
			emp.setEmpid((Integer)model.get("empid"));
			user.setPassword(newp);
			user.setEmp(emp);
			userservice.updateUser(user);
			mav=new ModelAndView((String)ses.getAttribute("role"));
			return mav;
		}

}
