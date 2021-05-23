package com.shop.models.requests;

import com.shop.models.Model;
import lombok.Data;

@Data
public class ModelRequest {
    private Model model;
    private Long country_id;
    private Long manufacturer_id;
}
