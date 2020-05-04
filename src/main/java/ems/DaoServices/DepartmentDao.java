package ems.DaoServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import ems.logger.Emslogger;
import ems.model.Department;
import ems.services.DepartmentServices;

public class DepartmentDao implements DepartmentServices{

	ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");

	@Transactional
	public boolean insertDepartment(Department d) {
		try {
		template.save(d);
		Emslogger.info("new Department added "+d.getDeptname());
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			Emslogger.error(e.getMessage());
			return false;
		}
	}
	@Transactional
	public boolean updateDepartment(Department d) {
	
		return false;
	}
	@Transactional
	public boolean deleteDepartment(Department d) {

		return false;
	}


}
