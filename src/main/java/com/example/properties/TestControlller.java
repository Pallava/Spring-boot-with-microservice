package com.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
//@Configuration
//@ConfigurationProperties(prefix = "income")
public class TestControlller {

    @Value("#{${properties}}")
    Map<String, List<String>> properties;
    @GetMapping("/test")
    public Map<String, List<String>> getValue() throws Exception {


        System.out.println(properties);
        return properties;
    }
}
