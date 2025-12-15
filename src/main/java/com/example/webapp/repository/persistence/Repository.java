package com.example.webapp.repository.persistence;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface Repository<T> {
    T save(T entity);
    T update(T entity);
    T findById(Object entityId);
    void delete(T entity);
    List<T> findAll();
}
