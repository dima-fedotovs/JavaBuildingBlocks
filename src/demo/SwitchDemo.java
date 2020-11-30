package demo;

import java.util.Scanner;

public class SwitchDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number from 1 to 3");
            int userNum = scanner.nextInt();
            switch (userNum) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                case 5:
                case 6:
                    System.out.println("Too many");
                    break;
                default:
                    System.out.println("I don't know");
            }
        }
    }
}
