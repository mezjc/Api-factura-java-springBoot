package org.jmez.apifactura.persistence.repository;

import org.jmez.apifactura.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsCustomerByDni(String dni);

    Customer findByName (String name);
}
