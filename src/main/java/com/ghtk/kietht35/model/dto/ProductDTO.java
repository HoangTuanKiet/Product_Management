package com.ghtk.kietht35.model.dto;

import com.ghtk.kietht35.model.entity.ProductEntity;
import lombok.Data;

@Data
public class ProductDTO {
    private String productName;
    private Integer price;
    private String sku;
    private String description;
    private Integer categoryId;
    private String code;
}
