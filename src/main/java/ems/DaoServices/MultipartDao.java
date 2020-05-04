package ems.DaoServices;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ems.functions.FileCreater;
import ems.logger.Emslogger;
import ems.model.Employee;
import ems.services.MultipartServices;

public class MultipartDao implements MultipartServices {
private static final String path="/images";
ApplicationContext ctx = new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
	Transaction txn;
	Session session;
	@Transactional(rollbackOn = Exception.class)
	
	public boolean uploadEmployeeImages(List<CommonsMultipartFile> list,int empid) {
		try {
		byte[] img=list.get(0).getBytes();
		byte[] adhar=list.get(1).getBytes();
		byte[] pan=list.get(2).getBytes();
		if(FileCreater.checkDir(path)) {
			FileCreater.moveFile(path+"/"+empid+"_image.jpg", img);
			FileCreater.moveFile(path+"/"+empid+"_adhar.jpg",adhar);
			FileCreater.moveFile(path+"/"+empid+"_pan.jpg", pan);
		}
		session=template.getSessionFactory().openSession();
		txn=session.beginTransaction();
		@SuppressWarnings("unchecked")
		NativeQuery<Employee> query=session.createNativeQuery("update Employee set image=:i1,adharimage=:i2,panimage=:i3 where empid=:empid");
		query.setParameter("i1", img);
		query.setParameter("i2", adhar);
		query.setParameter("i3", pan);
		query.setParameter("empid",empid);
		query.executeUpdate();
		Emslogger.info("images added of employee"+empid);
		txn.commit();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			Emslogger.error("error adding images"+e.getMessage());
			return false;
			}
	}

	public void deleteFile(List<String> names) { 
		// TODO Auto-generated method stub
		
	}

}
