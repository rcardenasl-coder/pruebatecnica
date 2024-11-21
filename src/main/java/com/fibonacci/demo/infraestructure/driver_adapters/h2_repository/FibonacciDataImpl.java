package com.fibonacci.demo.infraestructure.driver_adapters.h2_repository;

import com.fibonacci.demo.domain.model.Fibonacci;
import com.fibonacci.demo.domain.model.gateways.FibonacciGateway;
import com.fibonacci.demo.infraestructure.mapper.MapperFibonacci;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FibonacciDataImpl implements FibonacciGateway {
    private final FibonacciH2Repository repository;
    private final MapperFibonacci mapper;

    @Override
    public List<Fibonacci> findAll() {
        return repository.findAll().stream().map(mapper::toDo).toList();

    }

    @Override
    public Fibonacci createFibonacci(Fibonacci fibonacci) {
        return mapper.toDo(repository.save(mapper.dataFibonacci(fibonacci)));
    }
}
