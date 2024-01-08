package com.example.PriceGeneratorApp.B_service;

import com.example.PriceGeneratorApp.C_repository.CountryDiscountRepository;
import com.example.PriceGeneratorApp.C_repository.ProductRepository;
import com.example.PriceGeneratorApp.C_repository.QuotationRepository;
import com.example.PriceGeneratorApp.C_repository.UserRepository;
import com.example.PriceGeneratorApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//Dacă vârsta clientului este mai mare decât un prag stabilit
// pentru produsul pe care vrea să îl cumpere, atunci
// se aplică o reducere de 20% față de prețul de listă al produsului.
// Dacă nu, cotația rămâne egală cu prețul inițial.
@Service
public class QuotationService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CountryDiscountRepository countryDiscountRepository;
    private UserService userService;
    private QuotationRepository quotationRepository;

    @Autowired
    public QuotationService(UserRepository userRepository, ProductRepository productRepository, UserService userService, QuotationRepository quotationRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.quotationRepository = quotationRepository;
    }

    // generez o cotatie a unui user pentru un produs
        //am nevoie de un user cu un id
        //un produs cu un id
        //tin cont de conditii:
            // daca varsta userului este mai mare sau egala cu pragul impus
            // aplic reducerea de 20% la pretul produsului
    //
    @Transactional
    public Quotation generateQUotation(Long productId, Long userId) {
        // tre sa returnez o cotatie deci mi ar sa fac o cotatie
        Quotation quotation = new Quotation();
        //mai intai caut userul si produsul in baza de date care are i-dul dat ca parametru
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("product not found"));
        //daca userul are vrsta mai mare decat pragul stabili atunci cotatia mea va avea
        //o reducere de 0.2 din pretul de baza al produsului
        if (userService.getUserAge(user) >= product.getAgeDiscountThreshold()) {
                quotation.setAgeDiscount(product.getBasePrice()* 0.2);
        }
        //pentru a stabili reuducerea in functie de tara pentru produsul respectiv
        //caut tara din care este userul
        Country country = user.getCountry();
        // in baza de date am reducerea pentru tara respectiva
        //tre sa imi iau direct reducerea pentru tara respectiva
        CountryDiscount countryDiscount = countryDiscountRepository.findByCountryIdAndProduct_Id(productId, country.getId());
        quotation.setCountryDiscount(product.getBasePrice()* (countryDiscount.getDiscountValue()*100));
        //cum fac sa setez data de expirare a unei oferte
        //iau data curenta la care ii mai adaug 5 minute
        quotation.setExpireDate(LocalDate.from(LocalDateTime.now().plusMinutes(5)));
        quotation.setProduct(product);
        quotation.setUser(user);
        quotation.setPrice(product.getBasePrice() - quotation.getAgeDiscount() - quotation.getCountryDiscount());
        return quotationRepository.save(quotation);
    }
    public List<Quotation> getActiveQuotation(User user, LocalDate localDate) {
        return quotationRepository.findAllByUserAndExpireDateAfter(user, LocalDate.now());
    }

}
