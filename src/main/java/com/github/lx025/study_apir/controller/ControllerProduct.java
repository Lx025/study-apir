package com.github.lx025.study_apir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lx025.study_apir.model.Product;
import com.github.lx025.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

        Product productCreated = service.createProduct(product);
        return ResponseEntity.status(201).body(productCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Product productUpdated = service.updateProduct(id, product);

        return ResponseEntity.status(200).body(productUpdated);
    }

    @GetMapping
    public ResponseEntity<String> find() {
        service.getProductId(null);
        return ResponseEntity.status(200).body("Melancia");
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        service.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}
