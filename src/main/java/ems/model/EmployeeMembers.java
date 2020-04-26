package ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class EmployeeMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int slno;
	String name;
	long phoneno;
	String relation;
	long adharno;
	String email;
	@ManyToOne
	Employee emp;
	/**
	 * 
	 */
	public EmployeeMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param slno
	 * @param name
	 * @param phoneno
	 * @param relation
	 * @param adharno
	 * @param email
	 * @param emp
	 */
	public EmployeeMembers(int slno, String name, long phoneno, String relation, long adharno, String email,
			Employee emp) {
		super();
		this.slno = slno;
		this.name = name;
		this.phoneno = phoneno;
		this.relation = relation;
		this.adharno = adharno;
		this.email = email;
		this.emp = emp;
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public long getAdharno() {
		return adharno;
	}
	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
