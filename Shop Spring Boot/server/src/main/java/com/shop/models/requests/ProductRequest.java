package com.shop.models.requests;

import com.shop.models.Product;
import lombok.Data;

@Data
public class ProductRequest {
    private Product product;
    private Long model_id;
}
