package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    List<Product> products = new ArrayList<Product>();
//    Product product1 = new Product(1,"Title000", 300);
//    Product product2 = new Product(2,"Title2", 1110);
//    Product product3 = new Product(3,"Title3", 12321);

    public List<Product> getProducts() {
        return products;
    }

    public Product getById(int id) {
//        products.add(0,product1);
//        products.add(1,product2);
//        products.add(2,product3);
        System.out.println("----------");
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("get id "+product.getId());
                return product;
            };
        }
        return null;
    }
    public void addProduct(Product product){
        products.add(product);
        System.out.println(product.getId()+" repo");
        for (Product i : products) {
            System.out.println(i.getId());
        }
    }
}