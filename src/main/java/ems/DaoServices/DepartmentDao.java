package ems.DaoServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ems.model.Department;
import ems.services.DepartmentServices;

public class DepartmentDao implements DepartmentServices{

	ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");

	@Transactional
	public boolean insertDepartment(Department d) {
		template.save(d);
		return true;
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
