package bk.pnp.onlineshoppingBE.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@NotBlank(message = "Please Enter the Product name")
	private String proName;
	@NotBlank(message = "Please Enter the Brand  name")
	private String brdName;
	@NotBlank(message = "Please Enter the description")
	private String description;
	@Column(name = "price_unit")
	@Min(value = 1, message = "Please select at least one value")
	private double unitPrice;
	private int quantity;
	@Column(name = "is_active")
	private boolean active;
	@Column(name = "category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name = "supplier_id")
	@JsonIgnore
	private int supplierID;
	private int purchases;
	private int views;
	
	
	@Transient
	private MultipartFile mpf;
	
	
	//CONSTRUCTOR
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public String getBrdName() {
		return brdName;
	}


	public void setBrdName(String brdName) {
		this.brdName = brdName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getSupplierID() {
		return supplierID;
	}


	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}


	public int getPurchases() {
		return purchases;
	}


	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public MultipartFile getMpf() {
		return mpf;
	}


	public void setMpf(MultipartFile mpf) {
		this.mpf = mpf;
	}
	
	@Override
	public String toString() {
		return "Product [Id = " + id + ", Code = " + code + ", Product Name = " + proName + ", Brand Name = "
				+ brdName + ", Description = " + description + ", Price per Unit = " + unitPrice + ", Quantity = "
				+ quantity + ", Active = " + active + ", Category ID" + categoryId + ", Supplier  ID = " + supplierID 
				+ ", Purchases = " + purchases + ", Views = " + views + "]";
	}
}
