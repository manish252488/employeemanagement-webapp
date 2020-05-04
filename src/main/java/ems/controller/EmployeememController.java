package ems.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ems.model.Employee;
import ems.model.EmployeeMembers;
import ems.services.EmployeeMemberServices;

@Controller
@SessionAttributes("empid")
public class EmployeememController {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	EmployeeMemberServices servicemember=(EmployeeMemberServices)ctx.getBean("memdao");
	@PostMapping("/addmember")
	public ModelAndView addMember(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		Employee emp=new Employee();
		emp.setEmpid(Integer.parseInt(req.getParameter("empid")));
		EmployeeMembers em=new EmployeeMembers();
		em.setName(req.getParameter("name"));
		em.setPhoneno(Long.parseLong(req.getParameter("phno")));
		em.setRelation(req.getParameter("relation"));
		em.setAdharno(Long.parseLong(req.getParameter("adharno")));
		em.setEmail(req.getParameter("email"));
		em.setEmp(emp);
		ModelAndView m=new ModelAndView();
		if(servicemember.addMember(em)) {
			m.setViewName("addspouse");
			m.addObject("emp", emp.getEmpid());
		}else {
			m.setViewName("error");
		}
		return m;

	}
}
