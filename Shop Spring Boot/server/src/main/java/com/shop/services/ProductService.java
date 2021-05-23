package com.shop.services;

import com.shop.models.Model;
import com.shop.models.Product;
import com.shop.repositories.ModelRepository;
import com.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelRepository modelRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product setModel(Product product, Long model_id) {
        Model model = modelRepository.findById(model_id).orElseThrow();
        product.setModel(model);
        product.setModel_id(model_id);
        return productRepository.save(product);
    }
}

