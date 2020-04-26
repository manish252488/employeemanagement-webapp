package ems.services;

import ems.model.Department;

public interface DepartmentServices {
	

	public boolean insertDepartment(Department d);

	public boolean updateDepartment(Department d);

	public boolean deleteDepartment(Department d);
}
