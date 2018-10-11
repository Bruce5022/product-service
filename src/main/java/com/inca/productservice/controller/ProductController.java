package com.inca.productservice.controller;

import com.inca.productservice.entity.Product;
import com.inca.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Product> list() {
        List<Product> products = productService.listProduct();
        for (Product pro : products) {
            pro.setName(port + ":" + pro.getName());
        }
        return products;
    }

    @RequestMapping("/findOne")
    public Product findOne(@RequestParam("id") Integer id) {
        Product product = productService.findOne(id);
        product.setName(port + ":" + product.getName());
        return product;
    }
}
