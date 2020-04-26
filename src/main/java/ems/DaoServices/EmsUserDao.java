package ems.DaoServices;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ems.functions.DateTime;
import ems.functions.FileCreater;
import ems.model.EmsUsers;
import ems.services.EmsUsersServices;
public class EmsUserDao implements EmsUsersServices{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
	Session s;
	Transaction tx;
	private static final String PATH="users";
	@Transactional
	public boolean addUser(EmsUsers user) {
		try{
			FileCreater.checkDir(PATH);
			FileCreater.checkDir(PATH+"/"+user.getEmp());
		template.save(user);	
		return true;
		}catch(Exception e) {
		return false;
		}
}
	@Transactional
	public boolean updateUser(EmsUsers user) {
		int empid=user.getEmp().getEmpid();
		String npass=user.getPassword();
		String q="update EmsUsers set password=:p,lastLogedIn=:log where emp_empid=:id";
		s=template.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		NativeQuery<EmsUsers> query=s.createNativeQuery(q);
		query.setParameter("p", npass);
		query.setParameter("id", empid);
		query.setParameter("log", DateTime.getCurrentDate());
		tx=s.beginTransaction();
		query.executeUpdate();
		tx.commit();
		return true;
	}
	@Transactional
	public boolean removeUser(EmsUsers user) {
		// TODO Auto-generated method stub
		return false;
	}

}
