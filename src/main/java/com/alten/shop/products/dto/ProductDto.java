package com.alten.shop.products.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductDto {

    private String   id;
    private String code;
    private String  name;
    private String  description;
    private Double  price;
    private Double  quantity;
    private String  inventoryStatus;
    private String  category;
    private String  image;
    private String rating;
}