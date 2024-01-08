package org.jmez.apifactura.service.impl;

import org.jmez.apifactura.controller.dto.CustomerPropfileDTO;
import org.jmez.apifactura.exceptions.BadRequestException;
import org.jmez.apifactura.exceptions.ObjectNotFoundException;
import org.jmez.apifactura.persistence.entity.Customer;
import org.jmez.apifactura.persistence.entity.Invoice;
import org.jmez.apifactura.persistence.repository.CustomerRepository;
import org.jmez.apifactura.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException());
    }

    @Override
    public Customer createOneCustomer(CustomerPropfileDTO customerPropfileDTO) {
        boolean customerExists = customerRepository.existsCustomerByDni(customerPropfileDTO.getDni());

        if (customerExists) throw new BadRequestException("the Customer already exists");


        Customer saveCustomer= new ModelMapper().map(customerPropfileDTO, Customer.class);

        return customerRepository.save(saveCustomer);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerPropfileDTO customerPropfileDTO) {
            Customer customer = getOneCustomer(id);

        new ModelMapper().map(customerPropfileDTO, customer);

            return customerRepository.save(customer);
    }

    @Override
    public void deleteOneCustomer(Long id) {
         getOneCustomer(id);
        customerRepository.deleteById(id);
    }
}
