package bk.pnp.onlineshoppingBE.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "grand_total")
	private double grandTotal;
	@Column(name = "cart_line")
	private int cartLines;
	
	//LINKING CUSTOMER WITH CART
	@OneToOne
	private Customer cus;
	
	public Customer getCus() {
		return cus;
	}
	public void setCus(Customer cus) {
		this.cus = cus;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	@Override
	public String toString(){
		return "CART [ID = " + Id + ", Grand Total = " + grandTotal + ", Cart Line = " + cartLines + "]";
	}
	
	
}
