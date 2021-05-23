package com.shop.services;

import com.shop.models.Country;
import com.shop.models.Manufacturer;
import com.shop.models.Model;
import com.shop.repositories.CountryRepository;
import com.shop.repositories.ManufacturerRepository;
import com.shop.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public Model setCountry(Model model, Long country_id) {
        Country country = countryRepository.findById(country_id).orElseThrow();
        model.setCountry(country);
        model.setCountry_id(country.getId());
        return modelRepository.save(model);
    }

    public Model setManufacturer(Model model, Long manufacturer_id) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturer_id).orElseThrow();
        model.setManufacturer(manufacturer);
        model.setManufacturer_id(manufacturer_id);
        return modelRepository.save(model);
    }
}
