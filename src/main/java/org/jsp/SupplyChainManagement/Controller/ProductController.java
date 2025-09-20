package org.jsp.SupplyChainManagement.Controller;

import java.util.List;

import org.jsp.SupplyChainManagement.Dto.ResponseStructure;
import org.jsp.SupplyChainManagement.Entity.Product;
import org.jsp.SupplyChainManagement.Service.ProductService;
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

@RestController
@RequestMapping("/Product")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable Integer id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product)
	{
		return productService.updateproduct(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable Integer id)
	{
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplier(@PathVariable Integer id)
	{
		return productService.getProductBySupplier(id);
	}
	
	@GetMapping("/{pageNumber}/{pageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Product>>> getproductByPaginationAndSorting(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@PathVariable String field)
	{
		return productService.getProductByPaginationAndSorting(pageNumber, pageSize, field);
	}
	
	@GetMapping("/products/{stockQuantity}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductsByStockQuantity(@PathVariable Integer stockQuantity)
	{
		return productService.getProductByStockQuantity(stockQuantity);
	}
}
