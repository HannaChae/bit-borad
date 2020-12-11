package com.example.demo.utils;

import com.example.demo.domains.ProductDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crawler extends Proxy {
    @Autowired ProductDto product;
    @Autowired Printer printer;
    public Box<ProductDto> crawling(String url){
        printer.accept("크롤링 대상 URL : "+url);
        try{
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Element productNames = rawData.select("a[class=shop_item_title]");
            Element options = rawData.select("a[class="shop_item_opt]");
            Element price = rawData.select("a[class=shop_item_pay]");
        }

    }
    
}
