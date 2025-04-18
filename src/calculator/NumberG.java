package calculator;

import java.math.BigDecimal;

public class NumberG<T extends Number> {//extends Number를 통해 숫자만 다루겠다고 제한 선언
    private final T number;

    @SuppressWarnings("unchecked")
    public NumberG(BigDecimal num){
        this.number = (T) num;
    }

    public T getNum() {
        return this.number;
    }
}