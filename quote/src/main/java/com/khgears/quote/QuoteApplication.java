package com.khgears.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//这个注解相当于@EnableAutoConfiguration(表示开启自动化配置，开启之后会自动进行spring和springmvc的配置)和@ComponentScan(开启包扫描能够将控制器注册到springmvc容器中)
@SpringBootApplication

public class QuoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuoteApplication.class, args);
    }

}
