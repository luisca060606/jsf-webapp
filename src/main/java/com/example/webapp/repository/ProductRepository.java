package com.example.webapp.repository;

import com.example.webapp.model.entity.Product;
import com.example.webapp.repository.persistence.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class ProductRepository extends CrudRepository<Product> {
    public ProductRepository() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

//    custom methods
    public List<Product> findAllName() {
//        query jpql
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE '%P%'");
        return query.getResultList();
    }
}
