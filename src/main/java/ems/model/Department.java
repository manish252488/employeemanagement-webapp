package ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int deptid;

@Column(unique = true)
String deptname;
String DepartmentHead;
String location;
@Column(unique = true)
String code;
/**
 * @param deptid
 * @param deptname
 * @param departmentHead
 * @param location
 * @param code
 */

public Department(int deptid, String deptname, String departmentHead, String location, String code) {
	super();
	this.deptid = deptid;
	this.deptname = deptname;
	DepartmentHead = departmentHead;
	this.location = location;
	this.code = code;
}
/**
 * 
 */
public Department() {
	super();
	// TODO Auto-generated constructor stub
}
public int getDeptid() {
	return deptid;
}
public void setDeptid(int deptid) {
	this.deptid = deptid;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
public String getDepartmentHead() {
	return DepartmentHead;
}
public void setDepartmentHead(String departmentHead) {
	DepartmentHead = departmentHead;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

}