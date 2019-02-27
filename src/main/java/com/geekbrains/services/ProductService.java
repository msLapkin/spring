package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
        return (List<Product>)productRepository.findAll();
    }

    public List<Product> getProductsByPrice(int min, int max) {
        return productRepository.findProductsByPriceBetween(min,max);
    }
}