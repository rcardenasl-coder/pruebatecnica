package com.fibonacci.demo.domain.usecase;

import com.fibonacci.demo.domain.model.EmailDetails;
import com.fibonacci.demo.domain.model.Fibonacci;
import com.fibonacci.demo.domain.model.gateways.EmailGateway;
import com.fibonacci.demo.domain.model.gateways.FibonacciGateway;
import com.fibonacci.demo.domain.model.valueObjs.ValueDate;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class FibonacciUseCase {
    private final FibonacciGateway fibonacciGateway;
    private final EmailGateway emailGateway;

    private List<Integer> generateFibonacci(LocalTime time){
        int seeds = time.getMinute();
        int size = time.getSecond();

        int x = seeds / 10;
        int y = seeds % 10;

        List<Integer> serie = new ArrayList<>();
        serie.add(x);
        serie.add(y);

        while (serie.size() < size) {
            int nextNumber = serie.get(serie.size() - 1) + serie.get(serie.size() - 2);
            serie.add(nextNumber);
        }

        Collections.reverse(serie);

        return serie;
    }

    private void senderEmail(List<Integer> integers){
        EmailDetails emailDetails = new EmailDetails("ronaldcardenas455@gmail.com",integers.toString(),"Prueba tecnica - Ronald Cardenas Lara");
        emailGateway.sendEmail(emailDetails);
    }

    public Fibonacci createFibonacci(Fibonacci fibonacci){
        List<Integer> serie = this.generateFibonacci(fibonacci.getValueDate().getValue());

        Fibonacci fibonacci1 = new Fibonacci.Builder()
                .valueData(new ValueDate(fibonacci.getValueDate().getValue()))
                .valuesFibonacci(serie)
                .build();
        //senderEmail(serie);
        fibonacciGateway.createFibonacci(fibonacci1);

        return fibonacci1;
    }


    public List<Fibonacci> getAllFibonacci(){
        return fibonacciGateway.findAll();
    }


}
