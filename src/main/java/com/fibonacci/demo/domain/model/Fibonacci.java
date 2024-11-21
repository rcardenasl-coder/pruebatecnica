package com.fibonacci.demo.domain.model;

import com.fibonacci.demo.domain.model.buildModel.AbstractBuilder;
import com.fibonacci.demo.domain.model.valueObjs.ValueDate;

import java.io.Serializable;
import java.util.List;

public class Fibonacci implements Serializable {
    private ValueDate valueDate;
    private List<Integer> valuesFibonacci;

    public Fibonacci() {}

    private Fibonacci(Builder builder) {
        this.valueDate = builder.valueDate;
        this.valuesFibonacci = builder.valuesFibonacci;
    }

    public ValueDate getValueDate() {
        return valueDate;
    }

    public List<Integer> getValuesFibonacci() {
        return valuesFibonacci;
    }

    public static class Builder extends AbstractBuilder<Fibonacci> {
        private ValueDate valueDate;
        private List<Integer> valuesFibonacci;

        public Builder valueData(ValueDate valueDate ) {
            this.valueDate = valueDate;
            return this;
        }

        public Builder valuesFibonacci(List<Integer> valuesFibonacci) {
            this.valuesFibonacci = valuesFibonacci;
            return this;
        }

        @Override
        public Fibonacci build() {
            return new Fibonacci(this);
        }
    }
}
