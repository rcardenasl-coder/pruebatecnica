package com.fibonacci.demo.infraestructure.driver_adapters.h2_repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FibonacciH2Repository extends JpaRepository<FibonacciData, Long> {
}
