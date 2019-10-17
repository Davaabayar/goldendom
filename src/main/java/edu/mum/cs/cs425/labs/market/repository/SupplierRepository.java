package edu.mum.cs.cs425.labs.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.labs.market.model.Supplier;



@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
