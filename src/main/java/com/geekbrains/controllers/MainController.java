package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductRepository;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String showHomePage(Model model) {
    //public String showHomePage() {
        model.addAttribute("products", productService.getAllProducts());
        //Page<Product> page = productRepository.findAllByPrice(PageRequest.of(1,10),18000);
        return "index";
    }

    @GetMapping
    public String filterProductsByPriceAndPage(Model model, @RequestParam int min, @RequestParam int max) {
        List<Product> result = null;
        if (min >= 0 && max >= 0) {
            result = productService.getProductsByPrice(min, max);
        }
        model.addAttribute("products", result);
        return "index";
    }
}