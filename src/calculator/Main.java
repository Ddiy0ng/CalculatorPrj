package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1;
        int n2;
        String type;
        String input;

        do {
            //n1
            while(true) {
                System.out.print("1st number. Enter a 'positive integer' or '0': ");
                try {
                    n1 = sc.nextInt();
                    if (n1 < 0) {
                        System.out.println("Wrong enter. Please enter again.");
                        continue;
                    }
                    sc.nextLine();//reset the Scanner
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Wrong enter. Please enter again.");
                    continue;
                }
                System.out.println("");
                break;
            }
            //n2
            while(true){
                System.out.print("2nd number. Enter a 'positive integer' or '0': ");
                try{
                    n2 = sc.nextInt();
                    if(n2 < 0){
                        System.out.println("Wrong enter. Please enter again.");
                        continue;
                    }
                    sc.nextLine();//reset the Scanner
                } catch(InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Wrong enter. Please enter again.");
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
                System.out.print("->");
                type = sc.nextLine();

                if(type.equals("+")){
                    System.out.printf("%nresult: %d%n", add(n1, n2));
                    break;
                }
                if(type.equals("-")){
                    System.out.printf("%nresult: %d%n", sub(n1, n2));
                    break;
                }
                if(type.equals("*")){
                    System.out.printf("%nresult: %d%n", mul(n1, n2));
                    break;
                }
                if(type.equals("/")){
                    if(n2 == 0){
                        System.out.println("\nn2 = 0, Can't divide by 0. Please enter without division.");
                        continue;
                    }
                    System.out.printf("%nresult: %f%n", div(n1, n2));
                    break;
                }
                else{
                    System.out.println("\nWrong enter. Please enter again.");
                    continue;
                }
            }

            //continue or exit
            System.out.println("\nEnter the option you want.");
            System.out.println("1. Continue: enter any letters");
            System.out.println("2. Exit: enter 'exit'");
            System.out.print("->");
            input = sc.nextLine();
            System.out.println("");
        }while(!input.trim().equals("exit"));
        System.out.println("Exit the calculator.");
    }

    static int add(int n1, int n2){
        return n1 + n2;
    }

    static int sub(int n1, int n2){
        return n1 - n2;
    }

    static int mul(int n1, int n2){
        return n1 * n2;
    }

    static double div(int n1, int n2){
        return (double)n1 / n2;
    }
}