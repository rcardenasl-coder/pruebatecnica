package com.fibonacci.demo.infraestructure.mapper;

import com.fibonacci.demo.domain.model.Fibonacci;
import com.fibonacci.demo.domain.model.valueObjs.ValueDate;
import com.fibonacci.demo.infraestructure.driver_adapters.h2_repository.FibonacciData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperFibonacci {
    public Fibonacci toDo(FibonacciData fibonacciData){
        return new Fibonacci.Builder()
                .valueData(new ValueDate(fibonacciData.getDateFibonacci()))
                .valuesFibonacci(fibonacciData.getValuesFibonacci())
                .build();
    }

    public FibonacciData dataFibonacci(Fibonacci fibonacci){
        return new FibonacciData().toBuilder()
                .valuesFibonacci(fibonacci.getValuesFibonacci())
                .dateFibonacci(fibonacci.getValueDate().getValue()).build();
    }

}
