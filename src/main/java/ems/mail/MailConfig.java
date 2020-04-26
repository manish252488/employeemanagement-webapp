package ems.mail;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*; 
public class MailConfig implements SendMail
{  
	private	Properties property;
	private Authenticator auth=null;
	private String user="",pass="";
	private Session s=null;
	
	public Properties getProperty() {
			return property;
	}
	public void setProperty(Properties property) {
		this.property = property;
	}
	public void initialize() {
		
		user=property.getProperty("user");
		pass=property.getProperty("password");
	   auth=new Authenticator() {

			public PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(user,pass);
	    	}
		};
		s=Session.getInstance(property,auth);
	}
	
	
	public Boolean sendmail(String subject,String body,String recipient)
	{
		initialize();
		//mesage creation
		Message msg=new MimeMessage(s);
		try {
			msg.setFrom(new InternetAddress(user));
			InternetAddress[] toadd= {new InternetAddress(recipient)};
			msg.setRecipients(Message.RecipientType.TO, toadd);
			msg.setSubject(subject);
			msg.setText(body);
			msg.setSentDate(new Date());
			Transport.send(msg);
			return true;
		}catch(Exception e) {e.printStackTrace();return false;}

		
	}

}  