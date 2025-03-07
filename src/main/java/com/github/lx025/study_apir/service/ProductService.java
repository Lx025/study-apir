package com.github.lx025.study_apir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.lx025.study_apir.model.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    private long sequence = 1L;

    public Product createProduct(Product product) {
        product.setId(sequence++);
        products.add(product);

        return product;
    }

    public Optional<Product> updateProduct(Long id, Product product) {

        return products.stream()
                .filter(e->e.getId().equals(id)).findFirst().map(p -> {

                    p.setNome(product.getNome());
                    return p;
                });

    }

    public void getProductId(Long id) {

    }

    public void deleteProduct(Long id) {

    }

}
