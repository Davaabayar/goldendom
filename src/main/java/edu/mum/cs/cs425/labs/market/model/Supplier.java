package edu.mum.cs.cs425.labs.market.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "suppliers")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	@NotNull(message = "* Required")
	@Digits(integer = 9, fraction = 0, message = "* Supplier number must be numeric; and a positive, integral value")
	@Column(name = "supplier_number", nullable = false, unique = true)
	private String supplierNumber;
	
	@NotBlank(message = "* Name is required.")
	private String name;
	
	@NotEmpty(message = "* Contact number is required.")
	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.")
	private String contactNumber;
	
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Supplier(String supplierNumber, @NotBlank(message = "* Required") String name, String contactNumber,
			List<Product> products) {
		super();
		this.supplierNumber = supplierNumber;
		this.name = name;
		this.contactNumber = contactNumber;
		this.products = products;
	}
	
}
