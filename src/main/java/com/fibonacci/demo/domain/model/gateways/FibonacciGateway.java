package com.fibonacci.demo.domain.model.gateways;

import com.fibonacci.demo.domain.model.Fibonacci;

import java.util.List;

public interface FibonacciGateway {
    public List<Fibonacci> findAll();
    public Fibonacci createFibonacci(Fibonacci fibonacci);
}
