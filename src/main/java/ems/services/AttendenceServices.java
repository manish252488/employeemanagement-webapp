package ems.services;

import ems.model.Attendence;

public interface AttendenceServices {

	public String addAttendence(Attendence att);
	public String leaveTime(Attendence att);
	public String completeShift(int empid);
}
