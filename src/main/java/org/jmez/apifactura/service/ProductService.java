package org.jmez.apifactura.service;

import org.jmez.apifactura.controller.dto.CustomerPropfileDTO;
import org.jmez.apifactura.controller.dto.ProductDTO;
import org.jmez.apifactura.persistence.entity.Customer;
import org.jmez.apifactura.persistence.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProdut();

    Product getOneProdut(Long id);

    Product createProdut(ProductDTO productDTO);
    Product updateProduct(Long id ,ProductDTO productDTO);

    void deleteProduct(Long id);
}
