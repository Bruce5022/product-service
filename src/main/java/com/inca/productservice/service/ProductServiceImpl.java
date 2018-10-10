package com.inca.productservice.service;

import com.inca.productservice.cache.ProductCache;
import com.inca.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(ProductService.name)
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> listProduct() {
        return new ArrayList<>(ProductCache.products.values());
    }

    @Override
    public Product findOne(Integer id) {
        return ProductCache.products.get(id);
    }
}
