package ems.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmsUsers {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
@OneToOne
Employee emp;
@Column(columnDefinition = "boolean Default false")
Boolean admin=false;
String password;
@Column(columnDefinition = "boolean Default false")
Boolean active=false;
Date lastLogedIn;
Time lasttime;


/**
 * 
 */
public EmsUsers() {
	super();
	// TODO Auto-generated constructor stub
}


/**
 * @param id
 * @param emp
 * @param admin
 * @param password
 * @param active
 * @param lastLogedIn
 * @param lasttime
 */
public EmsUsers(int id, Employee emp, Boolean admin, String password, Boolean active, Date lastLogedIn, Time lasttime) {
	super();
	this.id = id;
	this.emp = emp;
	this.admin = admin;
	this.password = password;
	this.active = active;
	this.lastLogedIn = lastLogedIn;
	this.lasttime = lasttime;
}


public Time getLasttime() {
	return lasttime;
}


public void setLasttime(Time lasttime) {
	this.lasttime = lasttime;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Employee getEmp() {
	return emp;
}


public void setEmp(Employee emp) {
	this.emp = emp;
}


public Boolean getAdmin() {
	return admin;
}


public void setAdmin(Boolean admin) {
	this.admin = admin;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Boolean getActive() {
	return active;
}


public void setActive(Boolean active) {
	this.active = active;
}


public Date getLastLogedIn() {
	return lastLogedIn;
}


public void setLastLogedIn(Date lastLogedIn) {
	this.lastLogedIn = lastLogedIn;
}



}
