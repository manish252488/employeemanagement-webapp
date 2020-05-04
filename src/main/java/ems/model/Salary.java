package ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Salary
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Salid;
	@OneToOne
	Employee emp;
	@Column(name = "salary_Status",nullable = true)
	boolean status;
	String bank_name;
	@Column(unique = true)
	String accno;
	String Ifsccode;
	double salary;
	double bonus;
	public Salary(int salid, Employee emp, boolean status, String bank_name, String accno, String ifsccode,
			double salary, double bonus) {
		super();
		Salid = salid;
		this.emp = emp;
		this.status = status;
		this.bank_name = bank_name;
		this.accno = accno;
		Ifsccode = ifsccode;
		this.salary = salary;
		this.bonus = bonus;
	}
	public Salary() {
		super();
	}
	public int getSalid() {
		return Salid;
	}
	public void setSalid(int salid) {
		Salid = salid;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getIfsccode() {
		return Ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		Ifsccode = ifsccode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
	

	
	
}
