package com.shop.controllers;

import com.shop.models.Model;
import com.shop.models.requests.ModelRequest;
import com.shop.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<Model> getModels () {
        return modelService.findAll();
    }

    @PostMapping
    public Model postModel (@RequestBody ModelRequest request) {
        Model model = modelService.saveModel(request.getModel());
        if (request.getCountry_id() != null)
            model = modelService.setCountry(model, request.getCountry_id());
        if (request.getManufacturer_id() != null)
            model = modelService.setManufacturer(model, request.getManufacturer_id());
        return model;
    }
}
