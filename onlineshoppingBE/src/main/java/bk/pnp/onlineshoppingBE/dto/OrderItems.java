package bk.pnp.onlineshoppingBE.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderItems implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product prdt;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderDetails details;
	@Column(name = "buying_price")
	private double price;
	@Column(name = "product_quantity")
	private int quantity;
	private double total;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getPrdt() {
		return prdt;
	}
	public void setPrdt(Product prdt) {
		this.prdt = prdt;
	}
	public OrderDetails getDetails() {
		return details;
	}
	public void setDetails(OrderDetails details) {
		this.details = details;
	}
	
	
}
