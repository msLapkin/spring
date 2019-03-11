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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String showHomePage(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        model.addAttribute("products", productService.getAllProducts());
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Product> pageProduct = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("pageProduct", pageProduct);
        //Page<Product> page = productRepository.findAllByPrice(PageRequest.of(1,10),18000);
        int allPages = pageProduct.getTotalPages();
        if (allPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, allPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }

    @GetMapping("/info")
    public String showInfoPage(Model model) {
        //public String showHomePage() {
        //model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("products", productService.getAllProducts());
        return "info";
    }

    @GetMapping
    public String filterProductsByPriceAndPage(
            Model model,
            @RequestParam double min,
            @RequestParam double max) {
        List<Product> result = null;
        if (min >= 0 && max >= 0) {
            result = productService.getProductsByPrice(min, max);
        }
        model.addAttribute("products", result);
        return "index";
    }

    @GetMapping("/product/add")
    public String addProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/product/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/";
    }
}