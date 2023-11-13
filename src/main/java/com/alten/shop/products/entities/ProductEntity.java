package com.alten.shop.products.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class ProductEntity {
    @Field(targetType = FieldType.OBJECT_ID)
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