package com.shop.controllers;

import com.shop.models.Country;
import com.shop.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getCountries () {
        return countryService.findAll();
    }

    @PostMapping
    public Country postCountry (@RequestBody Country country) {
        return countryService.saveCountry(country);
    }
}
