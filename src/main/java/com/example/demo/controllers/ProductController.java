package com.example.demo.controllers;

import java.util.List;
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
        System.out.println("서버로 넘어옴" +site);
        var count = productService.count();
        if(count == 0){
            switch(site){
                case "thepicker":
                map.put("count", productService.crawling("https://smartstore.naver.com/peaceontable/category/059417fe6b8d455c9da3356c8a80e07a?cp=1"));
                break;
            }
        }
        else{
                map.put("count", count);
        }
        return map;
    }
    @GetMapping("/products/{proNum}/count")
    public Map<?,?> increaseCount(@PathVariable String proNum){
        var map = px.hashmap();
        int result = productService.increaseCount(proNum);
        map.put("message", (result == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }

    @GetMapping("/products")
    public Map<?, ?> list(){
        var map = px.hashmap();
        List<ProductDto> l = productService.list();
        map.put("list", l);
        map.put("count", productService.count());
        return map;
    }
}