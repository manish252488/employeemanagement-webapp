package ems.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empid;
	Name name;  //done
	char sex;	//done
	Address add;
	@Column(unique = true,length = 12)
	long phoneno1;//done
	@Column(nullable = true,length = 12)
	long phoneno2;//done
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=16000000)
	private byte[] image;
	Date birthdate;
	@Column(unique = true)
	String email;
	@Column(updatable = false)
	Date uploaddate;
	@Column(updatable = false)
	Time uploadtime;
	@OneToOne
	Department dept;
	@OneToOne(mappedBy = "emp")
	Salary sal;
	String job; 
	long adhar;
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=16000000)
	private byte[] adharimage;
	String panno;
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(length=16000000)
	private byte[] panimage;
    @OneToOne(mappedBy = "emp")
	EmsUsers user;
    @OneToMany(mappedBy = "emp")
    List<EmployeeMembers> member;
	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public long getPhoneno1() {
		return phoneno1;
	}
	public void setPhoneno1(long phoneno1) {
		this.phoneno1 = phoneno1;
	}
	public long getPhoneno2() {
		return phoneno2;
	}
	public void setPhoneno2(long phoneno2) {
		this.phoneno2 = phoneno2;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}
	public Time getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Time uploadtime) {
		this.uploadtime = uploadtime;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Salary getSal() {
		return sal;
	}
	public void setSal(Salary sal) {
		this.sal = sal;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}
	public byte[] getAdharimage() {
		return adharimage;
	}
	public void setAdharimage(byte[] adharimage) {
		this.adharimage = adharimage;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public byte[] getPanimage() {
		return panimage;
	}
	public void setPanimage(byte[] panimage) {
		this.panimage = panimage;
	}
	public EmsUsers getUser() {
		return user;
	}
	public void setUser(EmsUsers user) {
		this.user = user;
	}
	public List<EmployeeMembers> getMember() {
		return member;
	}
	public void setMember(List<EmployeeMembers> member) {
		this.member = member;
	}
	/**
	 * @param empid
	 * @param name
	 * @param sex
	 * @param add
	 * @param phoneno1
	 * @param phoneno2
	 * @param image
	 * @param birthdate
	 * @param email
	 * @param uploaddate
	 * @param uploadtime
	 * @param dept
	 * @param sal
	 * @param job
	 * @param adhar
	 * @param adharimage
	 * @param panno
	 * @param panimage
	 * @param user
	 * @param member
	 */
	public Employee(int empid, Name name, char sex, Address add, long phoneno1, long phoneno2, byte[] image,
			Date birthdate, String email, Date uploaddate, Time uploadtime, Department dept, Salary sal, String job,
			long adhar, byte[] adharimage, String panno, byte[] panimage, EmsUsers user, List<EmployeeMembers> member) {
		super();
		this.empid = empid;
		this.name = name;
		this.sex = sex;
		this.add = add;
		this.phoneno1 = phoneno1;
		this.phoneno2 = phoneno2;
		this.image = image;
		this.birthdate = birthdate;
		this.email = email;
		this.uploaddate = uploaddate;
		this.uploadtime = uploadtime;
		this.dept = dept;
		this.sal = sal;
		this.job = job;
		this.adhar = adhar;
		this.adharimage = adharimage;
		this.panno = panno;
		this.panimage = panimage;
		this.user = user;
		this.member = member;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", sex=" + sex + ", add=" + add + ", phoneno1="
				+ phoneno1 + ", phoneno2=" + phoneno2 + ", image=" + Arrays.toString(image) + ", birthdate=" + birthdate
				+ ", email=" + email + ", uploaddate=" + uploaddate + ", uploadtime=" + uploadtime + ", dept=" + dept
				+ ", sal=" + sal + ", job=" + job + ", adhar=" + adhar + ", adharimage=" + Arrays.toString(adharimage)
				+ ", panno=" + panno + ", panimage=" + Arrays.toString(panimage) + ", user=" + user + ", member="
				+ member + "]";
	}
	

}
