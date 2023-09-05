package com.example.productbackend.mappers;

import com.example.productbackend.dtos.ProductRequest;
import com.example.productbackend.dtos.ProductResponse;
import com.example.productbackend.entities.Product;


public class ProductMapper {

    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setTelefone(request.telefone());
        product.setEmail(request.email());
        product.setRg(request.rg());
        return product;
    }

    public static ProductResponse toDTO(Product product) {
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getTelefone(),
                product.getEmail(),
                product.getRg());
    }

}
