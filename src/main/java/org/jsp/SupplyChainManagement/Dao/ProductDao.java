package org.jsp.SupplyChainManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.Entity.Product;
import org.jsp.SupplyChainManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao 
{
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(Integer id)
	{
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public  Optional<Product> updateproduct(Product product)
	{
		Optional<Product> products= productRepository.findById(product.getId());
		if(products.isPresent())
		{
			Product setproduct=products.get();
			setproduct.setName(product.getName());
			setproduct.setPrice(product.getPrice());
			setproduct.setStockQuantity(product.getStockQuantity());
			setproduct.setSupplier(product.getSupplier());
			productRepository.save(setproduct);
			return Optional.of(setproduct);
		}
		else
		{
			return Optional.empty();
		}
	}
	
	
	public void deleteProduct(Integer id)
	{
		productRepository.deleteById(id);
	}
	
	public List<Product> getProductBySupplier(Integer id)
	{
		return productRepository.getProductsBySupplierId(id);
	}
	
	public Page<Product> getProductByPaginationAndSorting(Integer pageNumber, Integer pageSize, String field) 
	{
	    return productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field).ascending()));
	}
	
	public List<Product> getProductByStockQuantity(Integer stockQuantity)
	{
		return productRepository.getProductByStockQuantity(stockQuantity);
	}
}
