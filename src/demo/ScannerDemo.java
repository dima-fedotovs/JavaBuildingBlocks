package demo;


import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        boolean isJohn = userName.equalsIgnoreCase("John");
        boolean isAda = userName.equalsIgnoreCase("Ada");

        if (isJohn || isAda) {
            System.out.println("You are John or Ada");
        } else {
            System.out.println("You are NOT John and NOT Ada");
        }


        System.out.println("Enter your favorite number");
        int favNum = scanner.nextInt();

        System.out.println("I know your favorite number. It is " + favNum);

        if (isJohn && favNum == 5) {
            System.out.println("Yahoooo!");
        } else {
            System.out.println("oops");
        }
    }

}
