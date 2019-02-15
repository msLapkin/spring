package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService=productService;
    }

    //http://localhost:8189/app/products/getProductById?id=1
    @RequestMapping(path="/getProductById", method= RequestMethod.GET)
    @ResponseBody
    public Product getStudentById(@RequestParam int id) {
        Product product = productService.getProdById(id);
        return product;
    }

    // http://localhost:8189/app/products/showProductById?id=1
    @RequestMapping(path="/showProductById", method=RequestMethod.GET)
    public String showStudentById(Model model, @RequestParam int id) {
        Product product = productService.getProdById(id);
        model.addAttribute("product", product);
        return "product-form-result";
    }
    // http://localhost:8189/app/products/add
    @RequestMapping("/add")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    // http://localhost:8189/app/products/result
    @RequestMapping("/result")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.add(product);
        System.out.println(product.getId() + " " + product.getTitle()+" controller");
        return "product-form-result";
    }

    @RequestMapping("/all")
    public String view(Model model) {
        model.addAttribute("products", productService.getAll());
        //productService.getAll();
        //System.out.println(product.getId() + " " + product.getTitle());
        return "products";
    }
}
