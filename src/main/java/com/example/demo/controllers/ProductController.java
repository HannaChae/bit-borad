package com.example.demo.controllers;

import java.util.Map;

import com.example.demo.domains.ProductDto;
import com.example.demo.services.ProductService;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    @Autowired Proxy px;
    @Autowired ProductService productService;
    @PostMapping("/products")
    public Map<?,?> registration(@RequestBody ProductDto product){
        var map = px.hashmap();
        map.put("message", px.message(productService.registration(product)));
        return map;
    }

    @GetMapping("/products/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site) {
        var map = px.hashmap();
        var count = productService.count();
        if(count == 0){
            switch(site){
                case "thepicker":
                map.put("count", productService.crawling("https://thepicker.net/shop_payment/?order_code=o202012119e2099abb29a8"));
                break;
            }
        }
        else{
                map.put("count", count);
        }
        return map;
    }
}