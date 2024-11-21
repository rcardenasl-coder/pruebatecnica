package com.fibonacci.demo.application.config;

import com.fibonacci.demo.domain.model.gateways.EmailGateway;
import com.fibonacci.demo.domain.model.gateways.FibonacciGateway;
import com.fibonacci.demo.domain.usecase.FibonacciUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FibonacciConf {
    @Bean
    public FibonacciUseCase fibonacciUseCase(FibonacciGateway fibonacciGateway, EmailGateway emailGateway){
        return new FibonacciUseCase(fibonacciGateway,emailGateway);
    }
}
