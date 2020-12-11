package com.example.demo.repositories;

import com.example.demo.domains.ProductDto;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
	public int insert(ProductDto product);
	public int count();

}
