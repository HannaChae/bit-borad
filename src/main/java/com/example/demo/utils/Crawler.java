package com.example.demo.utils;

import com.example.demo.domains.ProductDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crawler extends Proxy {
    @Autowired
    ProductDto product;
    @Autowired
    Printer printer;
    @Autowired Box<ProductDto> proBox;

    public Box<ProductDto> crawling(String url){
        printer.accept("크롤링 대상 URL : "+url);
        try{
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements productNames = rawData.select("a[class=QNNliuiAk3]");
            Elements options = rawData.select("a[class=vChbm1yu9U]");
            Elements prices = rawData.select("a[class=nIAdxeTzhx]");
            for(int i = 0; i < productNames.size(); i++){
            product = new ProductDto();
            product.setProductName(productNames.get(i).text());
            product.setOption(options.get(i).text());
            product.setPrice(prices.get(i).text());
            printer.accept("크롤링된 게시글" +i+"번 : " +product.toString());
            proBox.add(product);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return proBox;

    }
}