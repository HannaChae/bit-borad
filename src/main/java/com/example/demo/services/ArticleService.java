package com.example.demo.services;

import com.example.demo.domains.ArticleDto;

import org.springframework.stereotype.Component;

@Component
public interface ArticleService {

    public int write(ArticleDto article);

}