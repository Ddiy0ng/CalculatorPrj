package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator cal = new ArithmeticCalculator();

        int option = 0;//option
        NumberG<Number> n1 = null;
        NumberG<Number> n2 = null;
        int index = 0;//index
        BigDecimal newVal = null;//newValue
        BigDecimal result = null;
        BigDecimal compareNum = null;
        String type = null;//calculation
        String input = null;//exit

        while(true){

            System.out.println("Enter the option number you want.");
            System.out.println("1: Calculation");
            System.out.println("2: Get data");
            System.out.println("3: Set data");
            System.out.println("4: Remove oldest data");
            System.out.println("5: Compare data to number you Enter");
            System.out.println("6: Exit");
            System.out.print("-> ");
            try{
                option = sc.nextInt();
                sc.nextLine();//reset the Scanner

                switch(option){
                    case 1://Calculation
                        //n1
                        System.out.println("\n1st number. Enter a 'positive integer' or '0'");
                        while(true) {
                            System.out.print("-> ");
                            try {
                                n1 = new NumberG<>(sc.nextBigDecimal());
                                sc.nextLine();//reset the Scanner
                            } catch (InputMismatchException e) {
                                sc.nextLine();
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
                                n2 = new NumberG<>(sc.nextBigDecimal());
                                sc.nextLine();//reset the Scanner
                            } catch(InputMismatchException e){
                                sc.nextLine();
                                System.out.println("\nWrong enter. Please enter again.");
                                continue;
                            }
                            break;
                        }
                        //calculate
                        System.out.println("\nEnter the operation symbol you want to use. ");
                        while(true){
                            BigDecimal b1 = new BigDecimal(n1.getNum().toString());
                            BigDecimal b2 = new BigDecimal(n2.getNum().toString());

                            System.out.println("add: +");
                            System.out.println("sub: -");
                            System.out.println("mul: *");
                            System.out.println("div: /");
                            System.out.print("-> ");
                            try {
                                type = sc.nextLine();

                                if(cal.calculation(b1, b2, type) == null) {
                                    continue;
                                }
                                result = cal.calculation(b1, b2, type);
                                System.out.printf("Result: %s%n", result);
                                cal.addData(result);
                                System.out.println("Data size: " + cal.dataSize());
                                System.out.println();
                            }catch(NullPointerException n) {
                                System.out.println("\nWrong enter. Please Enter again.");
                                continue;
                            }
                            break;
                        }
                        break;

                    case 2://Get data
                        if(cal.dataSize() == 0){
                            System.out.println("There are no any data\n");
                            System.out.println();
                            break;
                        }
                        System.out.println("\nEnter the index you want to get.");
                        System.out.println("(Starts from 0)");
                        while(true){
                            System.out.print("-> ");
                            try{
                                index = sc.nextInt();
                                sc.nextLine();
                                if(index < 0 || index >= cal.dataSize()){
                                    System.out.println("\nEntered index exceeded the size. Please enter again.");
                                    continue;
                                }
                                break;
                            }catch(InputMismatchException e){
                                sc.nextLine();
                                System.out.println("\nWrong type Enter. Please enter again.");
                            }
                        }
                        System.out.printf("GetData: %s", cal.getData(index));
                        System.out.println("\n");
                        break;
                    case 3://Set data
                        if(cal.dataSize() == 0){
                            System.out.println("There are no any data to set\n");
                            System.out.println();
                            break;
                        }
                        System.out.println("\nEnter the index you want to set.");
                        System.out.println("(Starts from 0)");
                        while(true){
                            System.out.print("-> ");
                            try{
                                index = sc.nextInt();
                                sc.nextLine();
                                if(index < 0 || index >= cal.dataSize()){
                                    System.out.println("\nEntered index exceeded the size. Please enter again.");
                                    continue;
                                }
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.nextLine();//
                                System.out.println("\nWrong type Enter. Please enter again.");
                            }
                        }

                        System.out.println("\nEnter the value you want to set into.");
                        while(true){
                            System.out.print("-> ");
                            try{
                                newVal = sc.nextBigDecimal();
                                sc.nextLine();
                                break;
                            }
                            catch(InputMismatchException e){
                                sc.nextLine();//
                                System.out.println("\nWrong type Enter. Please enter again.");
                            }
                        }
                        cal.setData(index, newVal);
                        break;
                    case 4://Remove oldest data
                        if(cal.dataSize() == 0){
                            System.out.println("There are no any data to remove");
                            break;
                        }
                        cal.removeOldestData();
                        System.out.println();
                        break;
                    case 5: //Bigger num out
                        if(cal.dataSize() == 0){
                            System.out.println("There are no any data you can compare to.\n");
                            System.out.println();
                            break;
                        }
                        System.out.println("\nEnter the number You want to comapre to.");
                        System.out.println("(The number bigger than the entered number will be printed.)");
                        while(true) {
                            System.out.print("-> ");
                            try {
                                compareNum = sc.nextBigDecimal();
                                sc.nextLine();
                            }catch (InputMismatchException e){
                                sc.nextLine();
                                System.out.println("\nWrong enter. Please enter again.2");
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
                        if(input.trim().equals("exit")){
                            System.out.println("\n~*Exit the program*~");
                            return;
                        }
                        System.out.println("\n'Exit' denied. Going back to the menu.\n");
                        break;
                    default://Wrong Enter
                        System.out.println("Wrong Enter.");
                }
            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Wrong enter.\n");
            }

        }
    }
}