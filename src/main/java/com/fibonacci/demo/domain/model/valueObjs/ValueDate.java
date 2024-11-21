package com.fibonacci.demo.domain.model.valueObjs;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ValueDate implements Serializable {

    private LocalTime value;

    public ValueDate(String value) {
        if (value == null){
            throw new IllegalArgumentException("The DateTime value cannot be Null");
        }
        this.value = LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public ValueDate(LocalTime value) {
        if (value == null){
            throw new IllegalArgumentException("The DateTime value cannot be Null");
        }
        this.value = value;
    }

    public ValueDate() {
    }

    public LocalTime getValue() {
        return value;
    }
}
