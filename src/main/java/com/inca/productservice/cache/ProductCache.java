package com.inca.productservice.cache;

import com.inca.productservice.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductCache {

    public static final Map<Integer, Product> products = new HashMap<>();

    static {

        products.put(1, new Product(1, "苹果", 10, 10));
        products.put(2, new Product(2, "香蕉", 20, 20));
        products.put(3, new Product(3, "梨", 30, 30));
        products.put(4, new Product(4, "黄瓜", 40, 40));
        products.put(5, new Product(5, "葡萄", 50, 50));
        products.put(6, new Product(6, "红酒", 60, 60));

    }
}
