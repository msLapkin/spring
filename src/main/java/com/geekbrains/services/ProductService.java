package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public List<Product> getProductsByPrice(double min, double max) {
        return productRepository.findProductsByPriceBetween(min,max);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if (getAllProducts().size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, getAllProducts().size());
            list = getAllProducts().subList(startItem, toIndex);
        }
        Page<Product> pageProduct = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), getAllProducts().size());

        return pageProduct;
    }
}
