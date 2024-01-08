package com.example.PriceGeneratorApp.C_repository;

import com.example.PriceGeneratorApp.model.OrderPriceGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPriceGeneratorRepository extends JpaRepository<OrderPriceGenerator, Long> {
}
