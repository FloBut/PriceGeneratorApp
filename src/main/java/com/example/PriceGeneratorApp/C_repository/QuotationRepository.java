package com.example.PriceGeneratorApp.C_repository;
import com.example.PriceGeneratorApp.model.Quotation;
import com.example.PriceGeneratorApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {
    //gasesc toate cotatiile dupa un utilizator care sunt active
    List<Quotation> findAllByUserAndExpireDateAfter(User user, LocalDate localDate);
    void deleteAllByExpireDateBefore(LocalDateTime localDatetime);

}
