package org.jmez.apifactura.controller;

import org.jmez.apifactura.controller.dto.ProductDTO;
import org.jmez.apifactura.persistence.entity.Product;
import org.jmez.apifactura.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductContoller {

    public final ProductService productService;

    public ProductContoller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(productService.getAllProdut());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getOne(@Validated  @PathVariable Long id){
        return ResponseEntity.ok().body(productService.getOneProdut(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@Validated @RequestBody ProductDTO productDTO){
        Product product = productService.createProdut(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@Validated @PathVariable Long id, @RequestBody ProductDTO productDTO){
         Product product = productService.updateProduct(id, productDTO);
         return ResponseEntity.ok().body(product);
    }

}
