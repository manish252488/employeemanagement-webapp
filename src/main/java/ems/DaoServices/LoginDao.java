package ems.DaoServices;
import java.sql.Date;
import java.sql.Time;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import ems.functions.DateTime;
import ems.mail.MailConfig;
import ems.mail.SendMail;
import ems.model.Employee;
import ems.model.EmsUsers;
import ems.services.LoginServices;
public class LoginDao implements LoginServices {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
	HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
	Session s;
	@Transactional
	public String validateLogin(int empid, String password){

		s=template.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Employee emp=(Employee)s.get(Employee.class,empid);
		EmsUsers user=emp.getUser();
		if(password.equals(user.getPassword())){
			//validate last login if NULL send to change password else forward to profile page
			if(user.getAdmin()==true) {
				user.setActive(true);
				s.update(user);
				tx.commit();
				return "adminpanel";
			}else {
				user.setActive(true);
				user.setLastLogedIn(Date.valueOf(DateTime.getCurrentDate()));
				user.setLasttime(Time.valueOf(DateTime.getCurrentTime()));
				s.update(user);
				tx.commit();
				return "employeepanel";
			}
				
		}else
			return "login";

	}

	public boolean Logout() {
		return false;
	}

	public boolean forgotPassword(int empid,String pass) {
		s=template.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Employee emp=(Employee)s.get(Employee.class,empid);
		EmsUsers user=emp.getUser();
		String recipient=emp.getEmail();
		user.setPassword(pass);
		s.update(user);
		SendMail send=new MailConfig();
		send.sendmail("ems-reset password","your new password:"+pass , recipient);
		tx.commit();
		return true;
	}
}
