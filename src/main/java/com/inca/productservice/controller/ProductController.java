package com.inca.productservice.controller;

import com.inca.productservice.entity.Product;
import com.inca.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Product> list() {
        return productService.listProduct();
    }

    @RequestMapping("/findOne")
    public Product findOne(@RequestParam("id") Integer id) {
        return productService.findOne(id);
    }
}
