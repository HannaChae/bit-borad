package com.example.demo.repositories;

import java.util.List;

import com.example.demo.domains.ProductDto;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
	public int insert(ProductDto product);
	public int count();
	public List<ProductDto> selectAll();

}
