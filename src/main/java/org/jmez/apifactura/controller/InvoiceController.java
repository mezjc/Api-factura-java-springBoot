package org.jmez.apifactura.controller;

import org.jmez.apifactura.controller.dto.InvoiceDTO;
import org.jmez.apifactura.persistence.entity.Invoice;
import org.jmez.apifactura.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/save")
    public ResponseEntity<Invoice> saveInvoice(@Validated  @RequestBody InvoiceDTO invoiceDTO){
        Invoice invoice1 = invoiceService.createOneInvoice(invoiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoice1);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Invoice> getOne(@Validated @PathVariable Long id){
        return ResponseEntity.ok().body(invoiceService.getOneInvoice(id));
    }

    @GetMapping("/getByName/{client}")
    public ResponseEntity<Invoice> getByName(@Validated @PathVariable String client){
        return ResponseEntity.ok().body(invoiceService.getOneInvoiceByName(client));
    }


}
