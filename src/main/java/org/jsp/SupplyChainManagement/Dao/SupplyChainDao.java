package org.jsp.SupplyChainManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.Entity.Product;
import org.jsp.SupplyChainManagement.Entity.Supplier;
import org.jsp.SupplyChainManagement.Repository.SupplyChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyChainDao 
{
	@Autowired
	private SupplyChainRepository supplyChainRepository;
	
	public Supplier saveSupplier(Supplier supplier)
	{
		return supplyChainRepository.save(supplier);
	}
	
	
	public Optional<Supplier> getSuplierById(Integer id)
	{
		return supplyChainRepository.findById(id);
	}
	
	public List<Supplier> getAllSuppliers()
	{
		return supplyChainRepository.findAll();
	}
	
	
	public Supplier updateSupplier(Supplier supplier)
	{
		return supplyChainRepository.save(supplier);
	}
	
	public void deleteSupplier(Integer id)
	{
		supplyChainRepository.deleteById(id);
	}
	
	public Optional<Supplier> getSupplierByProduct(Product product)
	{
		return supplyChainRepository.findById(product.getSupplier().getId());
	}
	
	public Page<Supplier> getSupplierByPaginationAndSorting(Integer pageNumber,Integer pageSize,String field)
	{
		return supplyChainRepository.findAll(PageRequest.of(pageNumber, pageSize,Sort.by(field).ascending()));
	}
}
