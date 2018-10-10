package com.inca.productservice.service;

import com.inca.productservice.entity.Product;

import java.util.List;

public interface ProductService {

    String name="productService";

    List<Product> listProduct();


    Product findOne(Integer id);
}
