package ems.functions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmsImages {
	private static ApplicationContext ctx;

	public static String getMainIconPath() {
		ctx = new  ClassPathXmlApplicationContext("Dependencies.xml");
		String s=(String)ctx.getBean("mainicon");
		System.out.println("print path:"+s);
		return s;
	}

}
