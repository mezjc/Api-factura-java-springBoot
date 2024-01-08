package org.jmez.apifactura.service;

import org.jmez.apifactura.controller.dto.InvoiceDTO;
import org.jmez.apifactura.persistence.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAllInvoice();

    Invoice getOneInvoice(Long id);

    Invoice createOneInvoice(InvoiceDTO invoiceDTO);
    Invoice updateInvoce(Long id ,Invoice invoice);

    void deleteOneInvoice(Long id);



}
