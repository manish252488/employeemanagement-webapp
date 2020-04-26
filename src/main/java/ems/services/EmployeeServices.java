package ems.services;


import com.google.gson.JsonObject;

import ems.model.Employee;


public interface EmployeeServices {
	
	

	public int addEmployee(Employee emp);
	
	public boolean updateEmployee(Employee emp);
	
	public boolean removeEmployee(Employee emp);
	
	public Employee fetchEmployee(int empid);
	
	public JsonObject getNoOfEmployee();
	
	public int updateEmployeeDet(Employee emp);
	
}
