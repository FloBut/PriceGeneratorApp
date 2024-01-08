package com.example.PriceGeneratorApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate expireDate;

    @Column
    private Double ageDiscount;

    @Column
    private Double countryDiscount;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "orderPriceGenerator_id")
    private OrderPriceGenerator orderPriceGenerator;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Quotation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Double getAgeDiscount() {
        return ageDiscount;
    }

    public void setAgeDiscount(Double ageDiscount) {
        this.ageDiscount = ageDiscount;
    }

    public Double getCountryDiscount() {
        return countryDiscount;
    }

    public void setCountryDiscount(Double countryDiscount) {
        this.countryDiscount = countryDiscount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderPriceGenerator getOrder() {
        return orderPriceGenerator;
    }

    public void setOrder(OrderPriceGenerator orderPriceGenerator) {
        this.orderPriceGenerator = orderPriceGenerator;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
