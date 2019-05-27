package bk.pnp.onlineshoppingBE.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//PRIVATE FIELDS
	@Id //This is there PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please Enter Your Address")
	@Column(name = "address_line_one")
	private String lineOneAdd;
	@NotBlank(message = "Please Enter Your Address")
	@Column(name = "address_line_two")
	private String lineTwoAdd;
	@NotBlank(message = "Please Enter Your City")
	private String city;
	@NotBlank(message = "Please Enter Your Country")
	private String country;
	@NotBlank(message = "Please Enter Your Postal Code")
	@Column(name = "postal_code")
	private String postalCode;
	@Column(name = "billing")
	private boolean billing;
	@Column(name = "shipping")
	private boolean shipping;
	@Column(name = "user_id")
	private int userId;
	
	//SETTERS AND GETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLineOneAdd() {
		return lineOneAdd;
	}
	public void setLineOneAdd(String lineOneAdd) {
		this.lineOneAdd = lineOneAdd;
	}
	public String getLineTwoAdd() {
		return lineTwoAdd;
	}
	public void setLineTwoAdd(String lineTwoAdd) {
		this.lineTwoAdd = lineTwoAdd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//OVERRIDING MY FILEDS to A String. 
	@Override 
	public String toString() {
		return "Address [id = " + id + ", line One Address = " + lineOneAdd + ", Line Two Address = " + lineTwoAdd +
				", city = " + city + ", Country = " + country + ", Postal Code = " + postalCode + ", Billing = " 
				+ billing + "]";
	}
	
	
}
