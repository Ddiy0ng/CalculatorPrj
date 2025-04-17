package calculator;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;//반올림

public class ArithmeticCalculator {

    //컬렉현 캡슐화
    private ArrayList<BigDecimal> data = new ArrayList<BigDecimal>();

    //enum선언
    public enum Type{
        Add("+"),
        Sub("-"),
        Mul("*"),
        Div("/");

        String type;

        Type(String type) {
            this.type = type;
        }

        String getType(){
            return type;
        }

        //연산자 이름 출력
        static String nameCheck(String type){
            for(Type t : values()) {
                if(t.getType().equals(type)) {
                    return t.name();
                }
            }
            //없으면 null 출력
            return null;
        }
    }




    //다른 타입 계산 가능하도록 BigDecimal 이용

    BigDecimal calculation(BigDecimal b1, BigDecimal b2, String type) {

        switch(Type.nameCheck(type)) {
            case "Add":
                return b1.add(b2);
            case "Sub":
                return b1.subtract(b2);
            case "Mul":
                return b1.multiply(b2);
            case "Div":
                if(b2.signum() == 0) {
                    System.out.println("\nn2 = 0, Can't divide by 0. Please enter without division.");
                    return null;
                }
                return b1.divide(b2, 20, RoundingMode.HALF_UP);
            default:
                return null;
        }
    }

    //컬렉션 크기 확인
    int dataSize(){
        return data.size();
    }

    //컬렉션 삽입
    void addData(BigDecimal result) {
        data.add(result);
    }

    //컬렉션 GET
    BigDecimal getData(int num){
        return data.get(num);
    }

    //컬렉션 SET
    void setData(int num, BigDecimal newVal){
        System.out.printf("Set %dth data into %s", num, newVal);
        data.set(num, newVal);
        System.out.println();
    }

    // 컬렉션 REMOVE: 가장 먼저 저장된 데이터 삭제
    void removeOldestData(){
        data.remove(0);
        System.out.println("Deleted the oldest data");
    }
}
