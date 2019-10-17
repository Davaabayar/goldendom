package edu.mum.cs.cs425.labs.market.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.market.model.Supplier;


public interface SupplierService {
	public abstract List<Supplier> getAllSupplier();
	public abstract Page<Supplier> getAllSuppliersPaged(int pageno);
	public abstract Supplier saveSupplier(Supplier supplier);
}
