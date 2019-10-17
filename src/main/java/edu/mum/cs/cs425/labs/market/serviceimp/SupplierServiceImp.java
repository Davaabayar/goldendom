package edu.mum.cs.cs425.labs.market.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.market.model.Supplier;
import edu.mum.cs.cs425.labs.market.repository.SupplierRepository;
import edu.mum.cs.cs425.labs.market.service.SupplierService;

@Service
public class SupplierServiceImp implements SupplierService{

	private SupplierRepository supplierRepository;
	
	@Autowired
	public SupplierServiceImp(SupplierRepository repository) {
		this.supplierRepository = repository;
	}
	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Page<Supplier> getAllSuppliersPaged(int pageno) {
		return supplierRepository.findAll(PageRequest.of(pageno, 5, Sort.by("name")));
	}
	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
}
