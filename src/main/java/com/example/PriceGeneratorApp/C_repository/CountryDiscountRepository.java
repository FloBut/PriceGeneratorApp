package com.example.PriceGeneratorApp.C_repository;

import com.example.PriceGeneratorApp.model.CountryDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDiscountRepository extends JpaRepository<CountryDiscount, Long> {
    // vrea sa imi aduc din baza de date reducerea un functie de tara si de produs
    CountryDiscount findByCountryIdAndProduct_Id(Long productId, Long countryId);
}
