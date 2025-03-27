package com.github.lx025.study_apir.controller;

import java.util.List;
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

import dto.ProductRequestCreate;
import dto.ProductRequestUpdate;
import dto.ProductResponse;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody ProductRequestCreate dto) {
        Product productCreated = productService.createProduct(dto);

        ProductResponse response = new ProductResponse();
        response.setId(productCreated.getId());
        response.setNome(productCreated.getNome());
        response.setValor(productCreated.getValor());

        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = productService.deleteProduct(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequestUpdate dto) {

        return productService.updateProduct(id, dto)

                .map(productUpdated -> {
                    ProductResponse response = new ProductResponse();
                    response.setId(productUpdated.getId());
                    response.setNome(productUpdated.getNome());
                    response.setValor(productUpdated.getValor());
                    return response;
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
