package com.example.PriceGeneratorApp.C_repository;

import com.example.PriceGeneratorApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
