package ems.mail;

import java.util.Properties;

public interface SendMail {
public Properties getProperty();
public void setProperty(Properties property);
public void initialize();
public Boolean sendmail(String subject,String body,String recipient);
}
