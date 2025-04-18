package calculator;

import java.math.BigDecimal;

public class NumberG<T extends Number> {
    private T number;

    @SuppressWarnings("unchecked")
    public NumberG(BigDecimal num){
        this.number = (T) num;
    }

    public T getNum() {
        return this.number;
    }

    public void setNum(T number) {
        this.number = number;
    }
}