package com.example.merchantoffer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String welcome() {
        return "Hello and welcome to the MerchantOffer application. You can create a new Offer by making a POST request to /api/offers endpoint.";
    }
}
