package com.example.demo.impls;

import com.example.demo.domains.ProductDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired ProductRepository productRepository;
    @Override
    public int registration(ProductDto product) {
        return productRepository.insert(product);
    }
    @Override
    public int count() {
        return productRepository.count();
    }
    @Override
    public int crawling(String url) {
        return null;
    }
}
