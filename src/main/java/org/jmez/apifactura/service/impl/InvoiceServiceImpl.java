package org.jmez.apifactura.service.impl;

import org.jmez.apifactura.controller.dto.InvoiceDTO;
import org.jmez.apifactura.controller.dto.ProductInvoiceDTO;
import org.jmez.apifactura.exceptions.ObjectNotFoundException;
import org.jmez.apifactura.persistence.entity.Customer;
import org.jmez.apifactura.persistence.entity.Invoice;
import org.jmez.apifactura.persistence.entity.InvoiceDetails;
import org.jmez.apifactura.persistence.entity.Product;
import org.jmez.apifactura.persistence.repository.CustomerRepository;
import org.jmez.apifactura.persistence.repository.InvoiceRepository;
import org.jmez.apifactura.persistence.repository.ProductRepository;
import org.jmez.apifactura.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getOneInvoice(Long id) {
        return invoiceRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException());
    }

    @Override
    public Invoice createOneInvoice(InvoiceDTO invoiceDTO) {
        Customer customer = customerRepository.findById(invoiceDTO.getClient()).get();
        Invoice invoice = new Invoice();
        Double total = 0.0;

        List<ProductInvoiceDTO> productInvoiceDTOS = invoiceDTO.getInvoiceDTO();
        List<InvoiceDetails> invoiceDetailsList = new ArrayList<>();

        for (ProductInvoiceDTO producto: productInvoiceDTOS){
            Product product = productRepository.findByName(producto.getProduct());

            InvoiceDetails invoiceDetails = new InvoiceDetails();

            invoiceDetails.setQuantity(producto.getQuantity());
            invoiceDetails.setPriceXQuantity(product.getPrice() * producto.getQuantity());
            invoiceDetails.setProduct(product);
            invoiceDetails.setInvoice(invoice);

            invoiceDetailsList.add(invoiceDetails);
            total += invoiceDetails.getPriceXQuantity();
        }

        invoice.setTotal(total);
        invoice.setClient(customer);
        invoice.setDetails(invoiceDetailsList);

        return invoiceRepository.save(invoice);




    }

    @Override
    public Invoice updateInvoce(Long id, Invoice invoice) {
        return null;
    }

    @Override
    public void deleteOneInvoice(Long id) {

    }
}
