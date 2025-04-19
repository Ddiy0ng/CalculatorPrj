package calculator;

public class NumberG<T> {
    private T number;

    public T getNum() {
        return this.number;
    }
    public  void setNum(T num){
        this.number = num;
    }
}