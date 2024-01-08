package org.jmez.apifactura.controller;

import org.jmez.apifactura.controller.dto.CustomerPropfileDTO;
import org.jmez.apifactura.persistence.entity.Customer;
import org.jmez.apifactura.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Customer> getById(@Validated @PathVariable Long id){
        Customer customer = customerService.getOneCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@Validated @PathVariable Long id,@Validated @RequestBody CustomerPropfileDTO customerPropfileDTO){
        Customer customer = customerService.updateCustomer(id, customerPropfileDTO);
        return ResponseEntity.ok().body(customer) ;
    }


    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@Validated @RequestBody CustomerPropfileDTO customerPropfileDTO){
        System.out.println(customerPropfileDTO);
        Customer customer1 = customerService.createOneCustomer(customerPropfileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delteCustomer(@Validated @PathVariable Long id){
        customerService.deleteOneCustomer(id);
        return ResponseEntity.ok("The user was successfully deleted ");
    }



}
