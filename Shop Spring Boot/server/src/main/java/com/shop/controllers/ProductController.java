package com.shop.controllers;

import com.shop.models.Product;
import com.shop.models.requests.ProductRequest;
import com.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product postProduct(@RequestBody ProductRequest request) {
        Product product = productService.saveProduct(request.getProduct());
        if (request.getModel_id() != null)
            product = productService.setModel(product, request.getModel_id());
        return product;
    }
}
