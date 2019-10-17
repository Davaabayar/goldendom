package edu.mum.cs.cs425.labs.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.labs.market.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
