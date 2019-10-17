package edu.mum.cs.cs425.labs.market.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.market.model.Product;
import edu.mum.cs.cs425.labs.market.repository.ProductRepository;
import edu.mum.cs.cs425.labs.market.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Page<Product> getAllProductsPaged(int pageno) {
		return productRepository.findAll(PageRequest.of(pageno, 5, Sort.by("productNumber")));
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	
}
