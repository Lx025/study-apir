package com.github.lx025.study_apir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lx025.study_apir.model.Product;
import com.github.lx025.study_apir.repository.ProductRepository;

import dto.ProductRequestCreate;
import dto.ProductRequestUpdate;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(ProductRequestCreate dto) {
        Product product = dto.toModel();
        return repository.save(product);
    }

    public Optional<Product> getProductById(Long id) {

        return repository.findById(id);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> updateProduct(Long id, ProductRequestUpdate dto) {

        return repository.findById(id).map(p->repository.save(dto.toModel(p)));

    }

    public boolean deleteProduct(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}