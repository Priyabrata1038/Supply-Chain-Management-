package org.jsp.SupplyChainManagement.Controller;

import org.jsp.SupplyChainManagement.Dto.ResponseStructure;
import org.jsp.SupplyChainManagement.Entity.Orders;
import org.jsp.SupplyChainManagement.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
public class OrdersController 
{

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Orders>> placeOrder(@RequestBody Orders orders) 
    {
        return ordersService.placeorders(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable Integer id) 
    {
        return ordersService.getOrderById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders() 
    {
        return ordersService.getAllOrders();
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Orders>> updateOrder(@RequestBody Orders orders) 
    {
        return ordersService.updateOrder(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Orders>> deleteOrder(@PathVariable Integer id) 
    {
        return ordersService.deleteOrder(id);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<ResponseStructure<Orders>> getOrderByTrackingNumber(@PathVariable String trackingNumber)
    {
        return ordersService.getOrderByTrackingNumber(trackingNumber);
    }

    @GetMapping("/amount/{amount}")
    public ResponseEntity<ResponseStructure<List<Orders>>> getOrdersByAmountGreater(@PathVariable double amount) 
    {
        return ordersService.getOrdersByAmountGreater(amount);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ResponseStructure<List<Orders>>> getOrdersByStatus(@PathVariable String status) 
    {
        return ordersService.getOrdersByStatus(status);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseStructure<List<Orders>>> getOrdersByCustomer(@PathVariable Integer customerId)
    {
        return ordersService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/pagination")
    public ResponseEntity<ResponseStructure<Page<Orders>>> getOrdersByPaginationAndSorting(
            @RequestParam int pageNumber, 
            @RequestParam int pageSize, 
            @RequestParam String field) 
    {
        return ordersService.getOrdersByPaginationAndSorting(pageNumber, pageSize, field);
    }
}
