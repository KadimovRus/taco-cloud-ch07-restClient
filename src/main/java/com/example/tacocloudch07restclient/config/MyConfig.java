package com.example.tacocloudch07restclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.example.tacocloudch07restclient")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
