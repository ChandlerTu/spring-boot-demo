package com.chandlertu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  CommandLineRunner init() {
    return args -> System.out.println("init");

  }

}
