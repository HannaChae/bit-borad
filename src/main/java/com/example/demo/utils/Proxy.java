package com.example.demo.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
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
    public File mkdir(String t, String u){
        BiFunction<String, String, File> f = File::new;
        return f.apply(t, u);
    }
    public File mkfile(File t, String u){
        BiFunction<File, String, File> f = File::new;
        return f.apply(t, u);
    }
}
