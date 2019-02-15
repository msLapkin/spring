package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductsRepository productsRepository;
    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProdById(int id) {
        Product product = productsRepository.getById(id);
        return product;
    }

    public List<Product> getAll(){
//        for (Product product: productsRepository.getProducts()) {
//            System.out.println("id:" +product.getId());
//        }
         return productsRepository.getProducts();
    }

    public void add(Product product){
        productsRepository.addProduct(product);
        System.out.println(product.getId()+" service");
    }

}
