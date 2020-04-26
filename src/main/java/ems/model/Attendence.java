package ems.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "attendence_log")
public class Attendence {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
int slno;
int empid;
Time intime;
Time outtime;
Time hoursWorked;
Date day;
/**
 * @param slno
 * @param empid
 * @param intime
 * @param outtime
 * @param hoursWorked
 * @param day
 */
public Attendence(int slno, int empid, Time intime, Time outtime, Time hoursWorked, Date day) {
	super();
	this.slno = slno;
	this.empid = empid;
	this.intime = intime;
	this.outtime = outtime;
	this.hoursWorked = hoursWorked;
	this.day = day;
}
/**
 * 
 */
public Attendence() {
	super();
	// TODO Auto-generated constructor stub
}
public int getSlno() {
	return slno;
}
public void setSlno(int slno) {
	this.slno = slno;
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public Time getIntime() {
	return intime;
}
public void setIntime(Time intime) {
	this.intime = intime;
}
public Time getOuttime() {
	return outtime;
}
public void setOuttime(Time outtime) {
	this.outtime = outtime;
}
public Time getHoursWorked() {
	return hoursWorked;
}
public void setHoursWorked(Time hoursWorked) {
	this.hoursWorked = hoursWorked;
}
public Date getDay() {
	return day;
}
public void setDay(Date day) {
	this.day = day;
}

}
