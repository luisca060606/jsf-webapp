package com.example.webapp.service.impl;

import com.example.webapp.model.entity.Product;
import com.example.webapp.repository.ProductRepository;
import com.example.webapp.service.IProductService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class ProductServiceImpl implements IProductService{
    @EJB
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product edit(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> listar() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllName() {
        return productRepository.findAllName();
    }
}
