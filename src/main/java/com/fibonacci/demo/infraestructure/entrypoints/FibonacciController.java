package com.fibonacci.demo.infraestructure.entrypoints;

import com.fibonacci.demo.domain.model.Fibonacci;
import com.fibonacci.demo.domain.usecase.FibonacciUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fibonacci")
@RequiredArgsConstructor
@Log4j2
public class FibonacciController {
    private final FibonacciUseCase useCase;

    @PostMapping()
    public ResponseEntity<Fibonacci> createFibonacci(@RequestBody Fibonacci fibonacci){
        log.info("Create fibonacci values and save BD");

        Fibonacci fibonacci1 = useCase.createFibonacci(fibonacci);

        if (fibonacci1.getValueDate().getValue() == null){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(fibonacci1, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Fibonacci>> findAll(){
        List<Fibonacci> fibonaccis = useCase.getAllFibonacci();
        if (fibonaccis.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fibonaccis, HttpStatus.OK);
    }

}
