package calculator;

import java.math.BigDecimal;

public class NumberG<T extends Number> {
    private final T number;

    @SuppressWarnings("unchecked")
    public NumberG(BigDecimal num){
        this.number = (T) num;
    }

    public T getNum() {
        return this.number;
    }
}