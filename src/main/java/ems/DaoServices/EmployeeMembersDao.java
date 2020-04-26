package ems.DaoServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import ems.model.EmployeeMembers;
import ems.services.EmployeeMemberServices;

public class EmployeeMembersDao implements EmployeeMemberServices {

	
	private ApplicationContext context = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	private HibernateTemplate template=(HibernateTemplate)context.getBean("template");
	
	@Transactional
	public boolean addMember(EmployeeMembers em) {
		
		template.save(em);
		return true;

	}
	@Transactional
	public boolean updateMember(EmployeeMembers em) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public boolean deleteMember(EmployeeMembers em) {
		// TODO Auto-generated method stub
		return false;
	}


}
