package com.example.PriceGeneratorApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;

    @Column
    private String password;
    @Column
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<OrderPriceGenerator> orderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Quotation> quotationList;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<OrderPriceGenerator> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderPriceGenerator> orderPriceGeneratorList) {
        this.orderList = orderPriceGeneratorList;
    }

    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
