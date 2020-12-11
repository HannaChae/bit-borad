package com.example.demo.impls;

import java.util.List;

import com.example.demo.domains.ProductDto;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import com.example.demo.utils.Box;
import com.example.demo.utils.Crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired ProductRepository productRepository;
@Autowired Crawler crawler;
@Autowired ProductDto product;
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
        var proBox = new Box<ProductDto>();
        proBox = crawler.crawling(url);
        System.out.println("box size: "+proBox.size());
        for(int i = 0; i< proBox.size(); i++){
            product = new ProductDto();
            product = proBox.get(i);
            System.out.println("Product: "+product.toString());
            product.setCount("0");
            registration(proBox.get(i));
        }
        return count();
    }

    @Override
    public int increaseCount(String proNum) {
        return productRepository.count();
    }
	@Override
	public List<ProductDto> list() {
		return productRepository.selectAll();
	}
}
