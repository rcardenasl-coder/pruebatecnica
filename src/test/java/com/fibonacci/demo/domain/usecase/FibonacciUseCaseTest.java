package com.fibonacci.demo.domain.usecase;

import com.fibonacci.demo.domain.model.EmailDetails;
import com.fibonacci.demo.domain.model.Fibonacci;
import com.fibonacci.demo.domain.model.gateways.EmailGateway;
import com.fibonacci.demo.domain.model.gateways.FibonacciGateway;
import com.fibonacci.demo.domain.model.valueObjs.ValueDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.*;

public class FibonacciUseCaseTest {

    @Mock
    private FibonacciGateway fibonacciGateway;

    @Mock
    private EmailGateway emailGateway;

    @InjectMocks
    private FibonacciUseCase fibonacciUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateFibonacci() {
        // Given
        LocalTime time = LocalTime.of(0, 12,12);  // 12 minutos y 0 segundos
        // Expected Fibonacci sequence: [1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377]

        Fibonacci fibonacci = new Fibonacci.Builder().valueData(new ValueDate(time)).build();
        List<Integer> fibonacciSequence = fibonacciUseCase.createFibonacci(fibonacci).getValuesFibonacci();

        // Then
        assert !fibonacciSequence.isEmpty();
    }

    @Test
    public void testCreateFibonacci() {
        ValueDate valueDate = new ValueDate(LocalTime.of(0, 12));
        Fibonacci fibonacci = new Fibonacci.Builder()
                .valueData(valueDate)
                .build();

        Fibonacci result = fibonacciUseCase.createFibonacci(fibonacci);

        assert result != null;
        assert !result.getValuesFibonacci().isEmpty();
        assert result.getValueDate().getValue().equals(valueDate.getValue());
        verify(fibonacciGateway, times(1)).createFibonacci(result);
    }

    @Test
    public void testGetAllFibonacci() {
        List<Fibonacci> fibonacciList = List.of(
                new Fibonacci.Builder().valueData(new ValueDate(LocalTime.of(0, 12))).build()
        );
        when(fibonacciGateway.findAll()).thenReturn(fibonacciList);

        List<Fibonacci> result = fibonacciUseCase.getAllFibonacci();

        assert result != null;
        assert result.size() == 1;
        verify(fibonacciGateway, times(1)).findAll();
    }
}
