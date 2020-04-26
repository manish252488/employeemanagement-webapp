package ems.controller;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ems.functions.DateTime;
import ems.mail.SendMail;
import ems.model.Address;
import ems.model.Department;
import ems.model.Employee;
import ems.model.EmsUsers;
import ems.model.Name;
import ems.model.Salary;
import ems.services.EmployeeServices;
import ems.services.EmsUsersServices;

@Controller
@SessionAttributes("emp")
public class EmployeeController {
		
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	EmployeeServices empservice=(EmployeeServices)ctx.getBean("empdao");
	EmsUsersServices userservice=(EmsUsersServices)ctx.getBean("userdao");
	SendMail send=(SendMail)ctx.getBean("mail");
		@PostMapping("/register")
		public ModelAndView RegiterEmployee(HttpServletRequest req,HttpServletResponse res,Model model)
		{
			
			Name name=new Name(req.getParameter("fname"),req.getParameter("mname"), req.getParameter("lname"));
			//creating salary object
			Salary sal=new Salary();
			sal.setBank_name(req.getParameter("bank_name"));
			sal.setIfsccode(req.getParameter("ifsc"));
			sal.setAccno(Long.parseLong(req.getParameter("accno")));
			sal.setSalary(Double.parseDouble(req.getParameter("salary")));
			sal.setBonus(Double.parseDouble(req.getParameter("bonus")));
			Address address=new Address(req.getParameter("state"), req.getParameter("city"), req.getParameter("add1"), 
					req.getParameter("add2"), req.getParameter("pincode"));
			
			
			Department dept=new Department();
			dept.setDeptid(Integer.parseInt(req.getParameter("dept")));

			Employee emp;
			emp=new Employee();
			emp.setName(name);
			emp.setSex((req.getParameter("sex")).charAt(0));
			emp.setAdd(address);
			emp.setEmail(req.getParameter("email"));
			emp.setPhoneno1(Long.parseLong(req.getParameter("phno1")));
			emp.setPhoneno2(Long.parseLong(req.getParameter("phno2")));
			Date bdate=Date.valueOf(req.getParameter("bdate"));
			emp.setBirthdate(bdate);
			emp.setUploaddate(Date.valueOf(DateTime.getCurrentDate()));
			emp.setUploadtime(Time.valueOf(DateTime.getCurrentTime()));
			emp.setAdhar(Long.parseLong(req.getParameter("adharno")));
			emp.setPanno(req.getParameter("panno"));
			emp.setDept(dept);
			emp.setSal(sal);
			emp.setJob(req.getParameter("job"));
			sal.setEmp(emp);
			EmsUsers user=new EmsUsers();
			String otp=RandomStringUtils.randomAlphanumeric(10);
			user.setPassword(otp);
			user.setEmp(emp);
			user.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
			emp.setUser(user);
			int empid=0;
			if((empid=empservice.addEmployee(emp))!=0 && userservice.addUser(user))
			{
				//sending mail
			String msg="Hello,"+emp.getName().getFname()+" your otp is:"+otp+"you can login with user employee id as username.";
			send.sendmail("ems-registration otp",msg, emp.getEmail());
			ModelAndView mav=new ModelAndView();
			mav.setViewName("addspouse");
			mav.addObject("empid", empid);
			return mav;
			}
			else 
				return null;
		}
		
		
		@PostMapping("/updateemp")
		public ModelAndView updateEmployee(HttpServletRequest req,HttpServletResponse res)
		{
			
			
		int empid=Integer.parseInt(req.getParameter("empid"));
		Name name=new Name(req.getParameter("fname"),req.getParameter("mname"), req.getParameter("lname"));
		//creating salary object
		Salary sal=new Salary();
		sal.setBank_name(req.getParameter("bank_name"));
		sal.setIfsccode(req.getParameter("ifsc"));
		sal.setAccno(Long.parseLong(req.getParameter("accno")));
		sal.setSalary(Double.parseDouble(req.getParameter("salary")));
		sal.setBonus(Double.parseDouble(req.getParameter("bonus")));
		Address address=new Address(req.getParameter("state"), req.getParameter("city"), req.getParameter("add1"), 
				req.getParameter("add2"), req.getParameter("pincode"));
		
		
		Department dept=new Department();
		dept.setDeptid(Integer.parseInt(req.getParameter("dept")));

		Employee emp=new Employee();
		emp.setEmpid(empid);
		emp.setName(name);
		emp.setSex((req.getParameter("sex")).charAt(0));
		emp.setAdd(address);
		emp.setEmail(req.getParameter("email"));
		emp.setPhoneno1(Long.parseLong(req.getParameter("phno1")));
		emp.setPhoneno2(Long.parseLong(req.getParameter("phno2")));
		Date bdate=Date.valueOf(req.getParameter("bdate"));
		emp.setBirthdate(bdate);
		emp.setUploaddate(Date.valueOf(DateTime.getCurrentDate()));
		emp.setUploadtime(Time.valueOf(DateTime.getCurrentTime()));
		emp.setAdhar(Long.parseLong(req.getParameter("adharno")));
		emp.setPanno(req.getParameter("panno"));
		emp.setDept(dept);
		emp.setSal(sal);
		emp.setJob(req.getParameter("job"));
		sal.setEmp(emp);
		if(empservice.updateEmployeeDet(emp)!=0){
		ModelAndView mav=new ModelAndView("index");
		return mav;
		}
		else {
			return null;
		}
		}
		
		@GetMapping("/deleteemp")
		public ModelAndView deleteEmployee(HttpServletRequest req,HttpServletResponse res)
		{
			int id=Integer.parseInt(req.getParameter("empid"));
			Employee emp=new Employee();
			emp.setEmpid(id);
			if(empservice.removeEmployee(emp)) {
				ModelAndView mav=new ModelAndView("index");
				return mav;
			}else
			
			return null;
		}
		@GetMapping("/profile")
		public ModelAndView fetchEmployee(HttpServletRequest req,HttpServletResponse res,HttpSession ses,Model model) {
			int empid=(Integer)ses.getAttribute("empid");
			Employee employee=empservice.fetchEmployee(empid);
			ModelAndView mav=new ModelAndView("profile");
			model.addAttribute("emp", employee);
			return mav;
		}
		@GetMapping("/employeecount")
public void getNoOfEmployee(HttpServletResponse res) {
	try {
		res.setContentType("text/json");
	PrintWriter out=res.getWriter();
	out.print(empservice.getNoOfEmployee());
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
