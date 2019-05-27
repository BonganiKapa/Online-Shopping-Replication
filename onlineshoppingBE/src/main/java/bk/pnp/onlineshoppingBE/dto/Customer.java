package bk.pnp.onlineshoppingBE.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;


@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter your first name:")
	@Column(name = "customer_name")
	private String cusName;
	@NotBlank(message = "Please enter your last name:")
	@Column(name = "last_name")
	private String lastName;
	@NotBlank(message = "Please enter your Email Address:")
	private String email;
	@NotBlank(message = "Please enter your contact details")
	@Column(name = "phone_number")
	private String contacts;
	private String role;
	@NotBlank(message = "Please enter you Password")
	private String password;
	private boolean accActive = true;
	@Transient
	private String confirmPw;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAccActive() {
		return accActive;
	}
	public void setAccActive(boolean accActive) {
		this.accActive = accActive;
	}
	public String getConfirmPw() {
		return confirmPw;
	}
	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}
	@Override
	public String toString() {
		return "Customer [ID = " + id + ", Customer Name = " + cusName + ", Last Name = " + lastName + ", Email = "
				+ email + ", Contacts = " + contacts + ", Role = " + role + ", Password = " + password + ", Enable = "
				+ accActive + "]";
	}
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
