package ems.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import ems.functions.GetFirstChar;
import ems.model.Department;
import ems.services.DepartmentServices;

@Controller
@SessionAttributes("empid")
public class DepartmentController{
	
ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
 DepartmentServices service=(DepartmentServices)ctx.getBean("deptdao");
	
	@PostMapping("/createdept")
	public ModelAndView createDepartment(HttpServletRequest req,HttpServletResponse res){
		
		String deptname=req.getParameter("deptname");
		String depthead=req.getParameter("depthead");
		String loc=req.getParameter("deptloc");
		Department dept=new Department();
		dept.setDeptname(deptname.toLowerCase());
		dept.setCode((GetFirstChar.getString(deptname)).toLowerCase());
		dept.setDepartmentHead(depthead.toLowerCase());
		dept.setLocation(loc.toLowerCase());
		ModelAndView mav=new ModelAndView();
		
		if(service.insertDepartment(dept)){
			mav.setViewName("index");
			return mav;
			 }else {
				mav.setViewName("createdept");
				return mav;
				}
	}
	
	
	@GetMapping("/deldept")
	public void deleteDepartment(HttpServletRequest req,HttpServletResponse res)
	{
		
	}
	@PostMapping("/updatedept")
	public void updateDepartment(HttpServletRequest req,HttpServletResponse res)
	{
		
	}
	
}
