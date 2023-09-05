package com.example.productbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productbackend.dtos.ProductRequest;
import com.example.productbackend.dtos.ProductResponse;
import com.example.productbackend.entities.Product;
import com.example.productbackend.mappers.ProductMapper;
import com.example.productbackend.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return this.repository.findAll();
    }

    public Product getProduct(long id){
        return this.repository
                   .findById(id)
                   .orElseThrow(
                     () -> new EntityNotFoundException("Product not found")
                   );
    }

    public void deleteProductById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Product not found");
        }
    }

    public ProductResponse save(ProductRequest product){
        var entity =this.repository.save(ProductMapper.toEntity(product));         
        return ProductMapper.toDTO(entity);
    }

    public void update(long id, Product product) {

        try{
            var updateProduct = this.repository.getReferenceById(id);
            updateProduct.setName(product.getName());
            updateProduct.setRg(product.getRg());
            updateProduct.setTelefone(product.getTelefone());
            updateProduct.setEmail(product.getEmail());
            this.repository.save(updateProduct);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Product not found");
        }

    }   

}


















