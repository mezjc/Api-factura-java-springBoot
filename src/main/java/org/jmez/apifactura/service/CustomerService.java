package org.jmez.apifactura.service;

import org.jmez.apifactura.controller.dto.CustomerPropfileDTO;
import org.jmez.apifactura.persistence.entity.Customer;
import org.jmez.apifactura.persistence.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer getOneCustomer(Long id);

    Customer createOneCustomer(CustomerPropfileDTO customerPropfileDTO);
    Customer updateCustomer(Long id ,CustomerPropfileDTO CustomerPropfileDTO);

    void deleteOneCustomer(Long id);
}
