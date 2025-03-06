package com.github.lx025.study_apir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lx025.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {

    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity<String> create(){
        service.createProduct(null);
        return ResponseEntity.status(201).body("Produto criado");
    }

    @PutMapping
    public ResponseEntity<String> update(){
        service.updateProduct(null, null);
        return ResponseEntity.status(200).body("produto atualizado");
    }

    @GetMapping
    public ResponseEntity<String> find(){
        service.getProductId(null);
        return ResponseEntity.status(200).body("Melancia");
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        service.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}
