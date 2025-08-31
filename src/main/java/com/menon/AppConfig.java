package com.menon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Autowired
    EurekaDiscoveryClient discoveryClient;

    @Bean
    @Scope("prototype")
    public WebClient authValidateWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(String.format("http://%s:%s/customer/v1/validate", "localhost", "8085"))
                .filter(new LoggingWebClientFilter())
                .build();
    }

}
