package com.github.lx025.study_apir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.lx025.study_apir.model.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

}
