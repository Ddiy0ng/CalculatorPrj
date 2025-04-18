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

    //enum선언
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

        //연산자 이름 출력
        static String nameCheck(String enteredType){
            for(Type t : values()) {
                if(t.getType().equals(enteredType)) {
                    return t.name();
                }
            }
            //없으면 null 출력
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
                result = b1.divide(b2, 20, RoundingMode.HALF_UP);//소수점 아래 자리수, 반올림
                break;
        }
        return result;
    }

    //컬렉션 크기 확인
    int dataSize(){
        return data.size();
    }

    //컬렉션 삽입
    void addData(BigDecimal result) {
        data.add(result);
    }

    //컬렉션 요소 GET
    BigDecimal getData(int num){
        return data.get(num);
    }

    //컬렉션 SET
    void setData(int num, BigDecimal newVal){
        System.out.printf("Set %dth data into %s%n", num, newVal);
        data.set(num, newVal);
        System.out.println();
    }

    // 컬렉션 REMOVE: 가장 먼저 저장된 데이터 삭제
    void removeOldestData(){
        data.remove(0);
        System.out.println("Deleted the oldest data");
    }

    //조건3
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