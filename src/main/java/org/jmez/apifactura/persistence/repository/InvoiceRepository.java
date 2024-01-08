package org.jmez.apifactura.persistence.repository;

import jakarta.persistence.Id;
import org.jmez.apifactura.persistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    Invoice findByClient_Name (String client);
}
