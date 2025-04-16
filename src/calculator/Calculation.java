package calculator;

import java.util.ArrayList;
import java.util.Objects;

public class Calculation {

    private ArrayList<String> data = new ArrayList<String>();

    int dataSize(){
        return data.size();
    }

    String getData(int num){
        return data.get(num);
    }

    void setData(int num, String newVal){
        System.out.printf("Set %dth data into %s", num, newVal);
        data.set(num, newVal);
        System.out.println();
    }

    void removeOldestData(){
        data.remove(0);
        System.out.println("Deleted the oldest data");
    }

    String add(int n1, int n2){
        String result = Integer.toString(n1 + n2);
        data.add(result);
        return result;
    }

    String sub(int n1, int n2){
        String result = Integer.toString(n1 - n2);
        data.add(result);
        return result;
    }

    String mul(int n1, int n2){
        String result = Integer.toString(n1 * n2);
        data.add(result);
        return result;
    }

    String div(int n1, int n2){
        String result = Double.toString((double) n1 / n2);
        data.add(result);
        return result;
    }

}
