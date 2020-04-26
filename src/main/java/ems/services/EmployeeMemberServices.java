package ems.services;


import ems.model.EmployeeMembers;

public interface EmployeeMemberServices {

	public boolean addMember(EmployeeMembers em);
	public boolean updateMember(EmployeeMembers em);
	public boolean deleteMember(EmployeeMembers em);

}
