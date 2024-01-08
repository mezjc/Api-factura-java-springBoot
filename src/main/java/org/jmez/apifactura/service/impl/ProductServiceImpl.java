package org.jmez.apifactura.service.impl;

import org.jmez.apifactura.controller.dto.ProductDTO;
import org.jmez.apifactura.exceptions.ObjectNotFoundException;
import org.jmez.apifactura.persistence.entity.Product;
import org.jmez.apifactura.persistence.repository.ProductRepository;
import org.jmez.apifactura.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProdut() {
        return productRepository.findAll();
    }

    @Override
    public Product getOneProdut(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException());
    }

    @Override
    public Product createProdut(ProductDTO productDTO) {
        Product saveProdut= new ModelMapper().map(productDTO, Product.class);
        saveProdut.setName(productDTO.getName().toLowerCase());

        return productRepository.save(saveProdut);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product product = getOneProdut(id);
        new ModelMapper().map(productDTO, product);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        getOneProdut(id);
        productRepository.deleteById(id);
    }
}
