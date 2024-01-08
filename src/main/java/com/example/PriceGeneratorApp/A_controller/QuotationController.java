package com.example.PriceGeneratorApp.A_controller;

import com.example.PriceGeneratorApp.B_service.QuotationService;
import com.example.PriceGeneratorApp.model.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotation")
public class QuotationController {
    private QuotationService quotationService;

    @Autowired
    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }
    // vreau sa verifc daca o cotatie a unui user pentru un produs a fost generata

    @PostMapping("/{productId}/{userId}")
    public ResponseEntity<Quotation> generateQuotation(
            @PathVariable  Long productId,
            @PathVariable Long userId) {
        Quotation generatedQuotation = quotationService.generateQUotation(productId, userId);
        return ResponseEntity.ok(generatedQuotation);
    }
}
