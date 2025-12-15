package com.example.webapp.service;

import com.example.webapp.model.entity.Product;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IProductService {
    Product save(Product product);
    Product edit(Product product);
    void delete(Product product);
    List<Product> listar();
    List<Product> findAllName();
}
