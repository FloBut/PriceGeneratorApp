package com.example.PriceGeneratorApp.config;
import com.example.PriceGeneratorApp.C_repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class QuotationConfig {
        private QuotationRepository quotationRepository;
        @Autowired
        public QuotationConfig (QuotationRepository quotationRepository) {
            this.quotationRepository = quotationRepository;
        }
        ///programex metoda pentru a rula la intervale regulate
    @Scheduled(cron = "0 0 * * * *")
    public void deleteDateExpirateEntities() {
        // Găsește entitățile cu data de expirare depășită
        quotationRepository.deleteAllByExpireDateBefore(LocalDateTime.now());
    }
}
