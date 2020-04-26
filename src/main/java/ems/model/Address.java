package ems.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
String state;
String city;
String address1;
String address2;
String pincode;
public Address(String state, String city, String address1, String address2, String pincode) {
	this.state = state;
	this.city = city;
	this.address1 = address1;
	this.address2 = address2;
	this.pincode = pincode;
}
/**
 * @param state
 * @param city
 * @param address1
 * @param address2
 * @param pincode
 */
/**
 * 
 */
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
public String getAddress1() {
	return address1;
}
public void setAddress1(String address1) {
	this.address1 = address1;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [state=" + state + ", city=" + city + ", address1=" + address1 + ", address2=" + address2
			+ ", pincode=" + pincode + "]";
}

}
