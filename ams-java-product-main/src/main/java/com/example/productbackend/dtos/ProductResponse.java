package com.example.productbackend.dtos;



public record ProductResponse(
    long id,
    String name,
    String rg,
    String telefone,
    String email
) {
    
}
