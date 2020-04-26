package ems.services;

public interface LoginServices {

	public String validateLogin(int empid,String password);
	public boolean Logout();
	public boolean forgotPassword(int empid,String pass);
}
