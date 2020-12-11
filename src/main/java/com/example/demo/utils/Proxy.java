package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {    
    public Map<String, Object> hashmap(){
        Supplier<Map<String, Object>> s = HashMap::new;
        return s.get();
    }
	public String message(int i) {
		return (i == 1) ? "SUCCESS" : "FAILURE";
	}
}
