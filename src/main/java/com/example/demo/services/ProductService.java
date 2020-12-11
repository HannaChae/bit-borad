package com.example.demo.services;

import com.example.demo.domains.ProductDto;

import org.springframework.stereotype.Component;

@Component
public interface ProductService {
	public int registration(ProductDto product);
	public int count();
	public int crawling(String url);
}