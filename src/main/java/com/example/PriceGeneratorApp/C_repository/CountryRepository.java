package com.example.PriceGeneratorApp.C_repository;

import com.example.PriceGeneratorApp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {


}
