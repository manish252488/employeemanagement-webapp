package ems.model;

import javax.persistence.Embeddable;

@Embeddable
public class Name {
String fname;
String mname;
String lname;

public Name(String fname, String mname, String lname) {
	this.fname = fname;
	this.mname = mname;
	this.lname = lname;
}

/**
 * 
 */
public Name() {
	super();
	// TODO Auto-generated constructor stub
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}

public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
@Override
public String toString() {
	return "Name [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
}
}
