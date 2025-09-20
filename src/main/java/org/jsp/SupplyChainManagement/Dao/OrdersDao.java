package org.jsp.SupplyChainManagement.Dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.Entity.Customer;
import org.jsp.SupplyChainManagement.Entity.Orders;
import org.jsp.SupplyChainManagement.Entity.Product;
import org.jsp.SupplyChainManagement.Exception.IdNotFoundException;
import org.jsp.SupplyChainManagement.Repository.CustomerRepository;
import org.jsp.SupplyChainManagement.Repository.OrdersRepository;
import org.jsp.SupplyChainManagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Orders placeorders(Orders orders) 
	{
	    Optional<Customer> customer = customerRepository.findById(orders.getCustomer().getId());
	    if (customer.isEmpty()) 
	    {
	        throw new IdNotFoundException("Customer not found with id " + orders.getCustomer().getId());
	    }

	    List<Product> products = new ArrayList<>();
	    double totalAmount = 0.0;

	    for (Product p : orders.getProducts()) 
	    {
	        Optional<Product> inlist = productRepository.findById(p.getId());
	        if (inlist.isPresent()) 
	        {
	            Product product = inlist.get();
	            products.add(product);
	            totalAmount += product.getPrice();  // Calculate total amount here
	        } 
	        else 
	        {
	            throw new IdNotFoundException("Product not found with id " + p.getId());
	        }
	    }

	    orders.setCustomer(customer.get());
	    orders.setProducts(products);
	    orders.setOrderDate(LocalDateTime.now());
	    orders.setStatus("PLACED");
	    orders.setTotalAmount(totalAmount);  // Set the calculated total

	    return ordersRepository.save(orders);
	}

	
	
    public Optional<Orders> getOrderById(Integer id) 
    {
        return ordersRepository.findById(id);
    }

    public List<Orders> getAllOrders() 
    {
        return ordersRepository.findAll();
    }

    public Optional<Orders> updateOrder(Orders orders) 
    {
        if (ordersRepository.existsById(orders.getId())) 
        {
            return Optional.of(ordersRepository.save(orders));
        }
        return Optional.empty();
    }

    public void deleteOrder(Integer id) 
    {
        ordersRepository.deleteById(id);
    }

    public Optional<Orders> getOrderByTrackingNumber(String trackingNumber) 
    {
        return ordersRepository.findByTrackingNumber(trackingNumber);
    }

    public List<Orders> getOrdersByAmountGreater(double amount) 
    {
        return ordersRepository.findByTotalAmountGreaterThan(amount);
    }

    public List<Orders> getOrdersByStatus(String status) 
    {
        return ordersRepository.findByStatus(status);
    }

    public List<Orders> getOrdersByCustomer(Customer customer) 
    {
        return ordersRepository.findByCustomer(customer);
    }

    public Page<Orders> getOrdersByPaginationAndSorting(int pageNumber, int pageSize, String field) 
    {
        return ordersRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field)));
    }


}
