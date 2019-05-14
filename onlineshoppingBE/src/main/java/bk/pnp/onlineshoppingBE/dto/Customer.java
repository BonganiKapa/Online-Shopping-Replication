package bk.pnp.onlineshoppingBE.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	//PRIVATE FIELDS
	@Id //ASSIGNING MY ID TO THE TABLE
	@GeneratedValue(strategy = GenerationType.IDENTITY) //INCREMENTING MY ID AS PER-USER
	private int id;
	private String customer_name;
	private String last_name;
	private String DOB;
	private String street_address;
	private String post_address;
	private String email;
	private String phone_number;
	
	//GETTERS & SETTERS METHOD
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost_address() {
		return post_address;
	}
	public void setPost_address(String post_address) {
		this.post_address = post_address;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
