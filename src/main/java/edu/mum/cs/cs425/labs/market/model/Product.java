package edu.mum.cs.cs425.labs.market.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@NotBlank(message="* Product number is a required field")
	private String productNumber;
	
	//@NotBlank(message="* required field")
	private String name;
	
	@NotNull(message = "* Quantity in stock is required")
    @Digits(integer = 9, fraction = 0, message = "* Quantity must be a positive, integral value")
    @PositiveOrZero(message = "* Quantity must be a positive, integral value")
	private int quantity;
	
	@NotNull(message = "* Unit Price is required")
	@Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
	@NumberFormat(pattern = "#,###.##")
	private Float unitprice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateSupplied;

	@ManyToOne()
	@JoinColumn(name = "supplierId", nullable = false)
	@NotNull(message = "* Supplier is required")
	private Supplier supplier;
	
	
	public Product(@NotBlank(message = "* Product number is a required field") String productNumber, String name,
			int quantity, Float unitprice, LocalDate dateSupplied) {
		this.productNumber = productNumber;
		this.name = name;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.dateSupplied = dateSupplied;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public LocalDate getDateSupplied() {
		return dateSupplied;
	}

	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
