package org.jsp.SupplyChainManagement.Controller;

import java.util.List;

import org.jsp.SupplyChainManagement.Dto.ResponseStructure;
import org.jsp.SupplyChainManagement.Entity.Product;
import org.jsp.SupplyChainManagement.Entity.Supplier;
import org.jsp.SupplyChainManagement.Service.SupplyChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Supplier")
@RestController
public class SupplyChainController 
{
	@Autowired
	private SupplyChainService supplyChainService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@RequestBody Supplier supplier)
	{
		return supplyChainService.saveSupplier(supplier);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@PathVariable Integer id)
	{
		return supplyChainService.getSupplierById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers()
	{
		return supplyChainService.getAllSuppliers();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@PathVariable Integer id,@RequestBody Supplier supplier)
	{
		supplier.setId(id);
		return supplyChainService.updateSupplier(supplier);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(@PathVariable Integer id)
	{
		return supplyChainService.deleteSupplier(id);
	}
	
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierByProduct(@PathVariable Integer id) {
	    return supplyChainService.getSupplierByProduct(id);
	}

	
	@GetMapping("/{pageNumber}/{pageSize}/{field}")
    public ResponseEntity<ResponseStructure<Page<Supplier>>> getBookByPaginationAndSorting(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@PathVariable String field)
    {
    	return supplyChainService.getBookByPaginationAndSorting(pageNumber, pageSize, field);
    }
}
