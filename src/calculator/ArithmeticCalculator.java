package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArithmeticCalculator {

    //Encapsulation Collection
    //final used for keeping data from being reassigned from other reference type
    private final List<BigDecimal> data = new ArrayList<>();

    public enum Type{
        Add("+"),//store "+" in the Type.Add field
        Sub("-"),
        Mul("*"),
        Div("/");

        private final String type;

        Type(String type) {
            this.type = type;
        }

        String getType(){//get private var type by using getter
            return type;
        }

        //print type name
        static String nameCheck(String enteredType){
            for(Type t : values()) {
                if(t.getType().equals(enteredType)) {
                    return t.name();
                }
            }
            return null;
        }
    }

    BigDecimal calculation(BigDecimal b1, BigDecimal b2, String type) {
        BigDecimal result = null;
        switch(Type.nameCheck(type)) {
            case "Add":
                result = b1.add(b2);
                break;
            case "Sub":
                result = b1.subtract(b2);
                break;
            case "Mul":
                result = b1.multiply(b2);
                break;
            case "Div":
                if(b2.signum() == 0) {//0 != 0.0 when they are BigDecimal. if it's 0, signum() returns 0
                    System.out.println("\nn2 = 0, Can't divide by 0. Please enter without division.");
                    break;
                }
                //if result is infinite decimal, ArithmeticException occurs. set scale and rounding to prevent it
                result = b1.divide(b2, 20, RoundingMode.HALF_UP);
                break;
        }
        return result;
    }

    //return Collection size
    int dataSize(){
        return data.size();
    }

    //insert data in Collection
    void addData(BigDecimal result) {
        data.add(result);
    }

    // get element from Collection
    BigDecimal getData(int num){
        return data.get(num);
    }

    //change element's value into new value
    void setData(int num, BigDecimal newVal){
        System.out.printf("Set %dth data into %s%n", num, newVal);
        data.set(num, newVal);
        System.out.println();
    }

    // remove the oldest data
    void removeOldestData(){
        data.remove(0);
        System.out.println("Deleted the oldest data");
    }

    BigNumOut BigList = new BigNumOut() {
        @Override
        public void bigList(BigDecimal scannerInput) {

            Stream<BigDecimal> stream = data.stream();
            Stream<BigDecimal> compare = stream.filter(index -> index.compareTo(scannerInput) > 0);
            List<BigDecimal> bigNumList = compare.collect(Collectors.toList());

            System.out.println(bigNumList);
        }
    };
}