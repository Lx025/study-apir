package com.github.lx025.study_apir.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.lx025.study_apir.model.Product;

import dto.ProductRequestCreate;

@Service
public class ProductService {
    

    private static List<Product> products = new ArrayList<>();
        
            private long sequence = 1L;

            private static final BigDecimal Valo_Padrao = new BigDecimal(200);
        
            public Product createProduct(ProductRequestCreate dto) {
                Product product = new Product();
                product.setId(sequence++);
                product.setNome(dto.getNome());
                product.setValor(Valo_Padrao);
                products.add(product);
        
                return product;
            }

            
        
            public Optional<Product> updateProduct(Long id, ProductRequestCreate dto) {
        
                return products.stream()
                .filter(p ->p.getId().equals(id))
                .findFirst()
                .map(p-> {
                    p.setValor(dto.getValor());
                    return p;
                });

    }

    public Optional<Product> getProductId(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Product> getAll(){
        return products;

    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(p->p.getId().equals(id));
    }

}
