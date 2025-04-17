package calculator;

import java.util.ArrayList;

public class Calculator {

    //컬렉현 캡슐화
    private ArrayList<String> data = new ArrayList<String>();

    //컬렉션 크기 확인
    int dataSize(){
        return data.size();
    }

    //컬렉션 GET
    String getData(int num){
        return data.get(num);
    }

    //컬렉션 SET
    void setData(int num, String newVal){
        System.out.printf("Set %dth data into %s", num, newVal);
        data.set(num, newVal);
        System.out.println();
    }

    // 컬렉션 REMOVE: 가장 먼저 저장된 데이터 삭제
    void removeOldestData(){
        data.remove(0);
        System.out.println("Deleted the oldest data");
    }

    // add
    String add(int n1, int n2){
        String result = Integer.toString(n1 + n2);
        data.add(result);
        return result;
    }

    // sub
    String sub(int n1, int n2){
        String result = Integer.toString(n1 - n2);
        data.add(result);
        return result;
    }

    //mul
    String mul(int n1, int n2){
        String result = Integer.toString(n1 * n2);
        data.add(result);
        return result;
    }

    //div
    String div(int n1, int n2){
        String result = Double.toString((double) n1 / n2);
        data.add(result);
        return result;
    }

}
