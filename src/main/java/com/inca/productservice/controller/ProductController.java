package com.inca.productservice.controller;

import com.inca.productservice.entity.Product;
import com.inca.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        List<Product> result = new ArrayList<>();
        List<Product> products = productService.listProduct();
        for (Product pro : products) {
            Product newPro = new Product();
            BeanUtils.copyProperties(pro, newPro);
            newPro.setName(port + ":" + pro.getName());
            result.add(newPro);
        }
        return result;
    }

    @RequestMapping("/findOne")
    public Product findOne(@RequestParam("id") Integer id) {
        Product newPro = new Product();
        Product product = productService.findOne(id);
        BeanUtils.copyProperties(product, newPro);
        newPro.setName(port + ":" + product.getName());
        return newPro;
    }
}
