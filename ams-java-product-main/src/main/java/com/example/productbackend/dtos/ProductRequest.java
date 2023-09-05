package com.example.productbackend.dtos;

    
import jakarta.validation.constraints.NotBlank;

public record ProductRequest(
    
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    
    @NotBlank(message = "Nome não pode ser em branco")
    String telefone,

    @NotBlank(message = "Nome não pode ser em branco")
    String email,

    @NotBlank(message = "Nome não pode ser em branco")
    String rg
) {
    
}
