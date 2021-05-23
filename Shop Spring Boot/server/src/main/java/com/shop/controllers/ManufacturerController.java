package com.shop.controllers;

import com.shop.models.Manufacturer;
import com.shop.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getManufacturers() {
        return manufacturerService.findAll();
    }

    @PostMapping
    public Manufacturer manufacturer (@RequestBody Manufacturer manufacturer) {
        return manufacturerService.saveManufacturer(manufacturer);
    }
}
