package edu.mum.cs.cs425.labs.market.service;

import java.util.List;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.labs.market.model.Product;



public interface ProductService {
	public abstract List<Product> getAllProducts();
	public abstract Page<Product> getAllProductsPaged(int pageno);
	public abstract Product addProduct(Product product);
}