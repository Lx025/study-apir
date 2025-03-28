package com.github.lx025.study_apir.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.lx025.study_apir.model.Product;
import com.github.lx025.study_apir.repository.ProductRepository;

import dto.ProductRequestCreate;
import dto.ProductRequestUpdate;




@Service
public class ProductService {
    private ProductRepository productRepository;

    private static final BigDecimal VALOR_PADRAO 
        = new BigDecimal(2000);

    public Product createProduct(ProductRequestCreate dto) {
        Product product = new Product();        
        product.setNome(dto.getNome());
        product.setValor(VALOR_PADRAO);
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        // return products.stream()
        //     .filter(p -> p.getId().equals(id))
        //     .findFirst();
        return null;
    }

    public List<Product> getAll() {
        return products;
    }

    public Optional<Product> updateProduct(
            Long id, ProductRequestUpdate dto) {

        return products.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> {                
                p.setValor(dto.getValor());
                return p;
                }
            );
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}