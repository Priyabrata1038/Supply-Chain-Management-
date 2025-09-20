package org.jsp.SupplyChainManagement.Controller;

import java.util.List;

import org.jsp.SupplyChainManagement.Dto.ResponseStructure;
import org.jsp.SupplyChainManagement.Entity.Customer;
import org.jsp.SupplyChainManagement.Service.CustomerService;
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
@RequestMapping("/Customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
    @PostMapping
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) 
    {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable Integer id) 
    {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() 
    {
        return customerService.getAllCustomers();
    }

    // 4. Update Customer
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer)
    {
        customer.setId(id);
        return customerService.updateCustomer(customer);
    }

    // 5. Delete Customer
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable Integer id) 
    {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/contact/{contact}")
    public ResponseEntity<ResponseStructure<Customer>> getCustomerByContact(@PathVariable long contact) 
    {
        return customerService.getCustomerByContact(contact);
    }

    @GetMapping("/{orderId}/customer")
    public ResponseEntity<ResponseStructure<Customer>> getCustomerByOrderId(@PathVariable int orderId) {
        return customerService.getCustomerByOrderId(orderId);
    }
    
    @GetMapping("/{pageNumber}/{pageSize}/{field}")
    public ResponseEntity<ResponseStructure<Page<Customer>>> getCustomerByPaginationAndSorting(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,@PathVariable String field) 
    {
        return customerService.getCustomerByPaginationAndSorting(pageNumber, pageSize, field);
    }

}
