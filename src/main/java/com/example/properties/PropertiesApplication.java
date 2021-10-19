package com.example.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class PropertiesApplication {



    public static void main(String[] args) {

        //System.out.println("Values--->"+values);
        SpringApplication.run(PropertiesApplication.class, args);
    }

}
