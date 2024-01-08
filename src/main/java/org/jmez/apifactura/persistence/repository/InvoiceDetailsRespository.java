package org.jmez.apifactura.persistence.repository;

import org.jmez.apifactura.persistence.entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailsRespository extends JpaRepository<InvoiceDetails, Long> {
}
