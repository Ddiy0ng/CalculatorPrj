package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

class NumberG<T> {
    private T number;

    public T getNum() {
        return this.number;
    }
    public  void setNum(T num){
        this.number = num;
    }
}

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner
        ArithmeticCalculator cal = new ArithmeticCalculator();//ArithmeticCalculator

        NumberG<String> strInput = new NumberG<>();
        NumberG<Integer> intInput = new NumberG<>();

        int option;//1~5th option
        int optionGet;
        int index;//stored data index
        BigDecimal n1;//first number
        BigDecimal n2;// second number
        BigDecimal newVal;//set into new number
        BigDecimal result;//calculation result
        BigDecimal compareNum;//compare number with stored data
        String type;//operator
        String input;//exit or not

        System.out.println("~*Program started*~\n");
        while(true){
            //option menu
            System.out.println("Enter the option number you want.");
            System.out.println("1: Calculation");
            System.out.println("2: Get data");
            System.out.println("3: Set data");
            System.out.println("4: Remove oldest data");
            System.out.println("5: Compare number");
            System.out.println("6: Exit");
            System.out.print("-> ");

            try{
                option = sc.nextInt();//1~6
                sc.nextLine();//empty the scanner buffer

                switch(option){
                    case 1://Calculation
                        //n1
                        System.out.println("\n1st number. Enter a 'positive integer' or '0'");
                        while(true) {
                            System.out.print("-> ");
                            try {
                                strInput.setNum(sc.nextLine());//1~6
                                n1 = new BigDecimal(strInput.getNum());
                            } catch (NumberFormatException e) {
                                //Wrong type entered error
                                System.out.println("\nWrong enter. Please enter again.");
                                continue;
                            }
                            break;
                        }
                        //n2
                        System.out.println("\n2nd number. Enter a 'positive integer' or '0'");
                        while(true){
                            try{
                                System.out.print("-> ");
                                strInput.setNum(sc.nextLine());
                                n2 = new BigDecimal(strInput.getNum());
                            } catch(NumberFormatException e){
                                //Wrong type entered error
                                System.out.println("\nWrong enter. Please enter again.");
                                continue;
                            }
                            break;
                        }
                        //calculate
                        System.out.println("\nEnter the operation symbol you want to use. ");
                        while(true){

                            System.out.println("add: +");
                            System.out.println("sub: -");
                            System.out.println("mul: *");
                            System.out.println("div: /");
                            System.out.print("-> ");
                            try {
                                type = sc.nextLine();
                                if(cal.calculation(n1, n2, type) == null) {
                                    continue;
                                }
                                result = cal.calculation(n1, n2, type);
                                System.out.printf("%nResult: %s %s %s = %s%n", n1, type, n2, result);
                                cal.addData(result);
                                System.out.printf("Data amount: %d%n", cal.dataSize());
                                System.out.println();
                            }catch(NullPointerException e) {//if Entered except +-*/
                                System.out.println("\nWrong enter. Please Enter again.");
                                continue;
                            }
                            break;
                        }
                        break;
                    case 2://Get data
                        System.out.println("\nChoose the option you want.");
                        System.out.println("1: Get all data");
                        System.out.println("2: Get one data");
                        System.out.println("3: Go back");
                        while(true){
                            System.out.print("-> ");
                            try{
                                optionGet = sc.nextInt();
                                sc.nextLine();

                                switch(optionGet){
                                    case 1:
                                        cal.getAllData();
                                        break;
                                    case 2:
                                        if(cal.dataSize() == 0){//Keep user from approaching data when collection is empty
                                            System.out.println("There are no any data\n");
                                            System.out.println();
                                            break;
                                        }
                                        System.out.println("\nEnter the index you want to get.");
                                        System.out.println("(Starts from 0)");
                                        while(true){
                                            System.out.print("-> ");
                                            try{
                                                intInput.setNum(sc.nextInt());
                                                index = intInput.getNum();
                                                sc.nextLine();//empty the scanner buffer
                                                if(index < 0 || index >= cal.dataSize()){
                                                    System.out.println("\nEntered index is out of bound. Please enter again.");
                                                    continue;
                                                }
                                                break;
                                            }catch(InputMismatchException e){
                                                sc.nextLine();
                                                System.out.println("\nWrong type Enter. Please enter again.");
                                            }
                                        }
                                        System.out.printf("%nGet data: %s%n", cal.getData(index));
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println("\nGo back\n");
                                        break;
                                    default:
                                        System.out.println("\nWrong enter. Please enter again.");
                                        continue;
                                }
                            }catch(InputMismatchException e){
                                sc.nextLine();
                                System.out.println("\nWrong enter. Please enter again.");
                                continue;
                            }
                            break;
                        }
                        break;
                    case 3://Set data
                        if(cal.dataSize() == 0){//Keep user from approaching data when collection is empty
                            System.out.println("\nThere are no any data to set\n");
                            System.out.println();
                            break;
                        }
                        System.out.println("\nEnter the index you want to set.");
                        System.out.println("(Starts from 0)");
                        while(true){
                            System.out.print("-> ");
                            try{
                                intInput.setNum(sc.nextInt());
                                index = intInput.getNum();
                                sc.nextLine();//empty the scanner buffer
                                if(index < 0 || index >= cal.dataSize()){
                                    System.out.println("\nEntered index is out of bound. Please enter again.");
                                    continue;
                                }
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.nextLine();//empty the scanner buffer
                                System.out.println("\nWrong type Enter. Please enter again.");
                            }
                        }

                        System.out.println("\nEnter the value you want to set into.");
                        while(true){
                            System.out.print("-> ");
                            try{
                                strInput.setNum(sc.nextLine());
                                newVal = new BigDecimal(strInput.getNum());
                                cal.setData(index, newVal);
                                break;
                            }
                            catch(NumberFormatException e){
                                System.out.println("\nWrong type Enter. Please enter again.");
                            }
                        }
                        break;
                    case 4://Remove oldest data
                        if(cal.dataSize() == 0){//Keep user from approaching data when collection is empty
                            System.out.println("\nThere are no any data to remove\n");
                            break;
                        }
                        cal.removeOldestData();
                        System.out.println();
                        break;
                    case 5: //Bigger num out
                        if(cal.dataSize() == 0){//Keep user from approaching data when collection is empty
                            System.out.println("\nThere are no any data you can compare to.\n");
                            System.out.println();
                            break;
                        }
                        System.out.println("\nEnter the number You want to compare to.");
                        System.out.println("(The number bigger than the entered number will be printed.)");
                        while(true) {
                            System.out.print("-> ");
                            try {
                                strInput.setNum(sc.nextLine());
                                compareNum = new BigDecimal(strInput.getNum());
                            }catch (NumberFormatException e){
                                System.out.println("\nWrong enter. Please enter again.");
                                continue;
                            }
                            cal.BigList.bigList(compareNum);
                            System.out.println();
                            break;
                        }
                        break;
                    case 6://exit
                        System.out.println("\nEnter 'exit' if you really want to exit the program.");
                        System.out.print("-> ");
                        input = sc.nextLine();
                        if(input.trim().equals("exit")){//check if input's still 'exit' after removing space
                            System.out.println("\n~*Exit the program*~");
                            return;
                        }
                        System.out.println("\n'Exit' denied. Going back to the menu.\n");
                        break;
                    default://No any option number except 1~7
                        System.out.println("\nWrong Enter.\n");
                }
            }
            catch (InputMismatchException e){//wrong enter
                sc.nextLine();//empty the scanner buffer
                System.out.println("\nWrong enter.\n");
            }
        }
    }
}