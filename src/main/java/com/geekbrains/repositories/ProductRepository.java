package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    //public Page<Product> findAllByPrice(PageRequest pageRequest, int price);
    public Product findProductById(Long id);
    public List<Product> findProductsByPriceBetween(int min, int max);
    public List<Product> findAll();
}
