package com.example.PriceGeneratorApp.B_service;

import com.example.PriceGeneratorApp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {
    //vreau sa calculez varsta in functie de data nasterii
    //scad din anul curent anu nasterii

@Transactional
    public Integer getUserAge(User user) {
        return Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
