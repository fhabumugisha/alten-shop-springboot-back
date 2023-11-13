package com.alten.shop.products.mappers;

import com.alten.shop.products.dto.ProductDto;
import com.alten.shop.products.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductsMapper {

   public ProductDto toDto(ProductEntity productEntity){
        return  ProductDto.builder()
                .id(productEntity.getId())
                .code(productEntity.getCode())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .inventoryStatus(productEntity.getInventoryStatus())
                .category(productEntity.getCategory())
                .image(productEntity.getImage())
                .rating(productEntity.getRating())

                .build();
    }

   public ProductEntity toEntity(ProductDto productDto){
     return    ProductEntity.builder().id(productDto.getId())
                .code(productDto.getCode())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .inventoryStatus(productDto.getInventoryStatus())
                .category(productDto.getCategory())
                .image(productDto.getImage())
                .rating(productDto.getRating()).build();
    }
}
