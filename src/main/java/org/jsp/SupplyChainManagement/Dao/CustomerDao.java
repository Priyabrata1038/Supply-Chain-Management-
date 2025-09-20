package org.jsp.SupplyChainManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.Entity.Customer;
import org.jsp.SupplyChainManagement.Entity.Orders;
import org.jsp.SupplyChainManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
    public Customer saveCustomer(Customer customer) 
    {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Integer id) 
    {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() 
    {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) 
    {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) 
    {
        customerRepository.deleteById(id);
    }

    public Customer getCustomerByContact(long contact) 
    {
        return customerRepository.findByContact(contact);
    }

    public Optional<Customer> getCustomerByOrders(int orderId)
    {
    	return customerRepository.findCustomerByOrderId(orderId);
    }
    
    
    public Page<Customer> getCustomerByPaginationAndSorting(Integer pageNumber, Integer pageSize, String field) 
    {
        return customerRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field).ascending()));
    }
}
