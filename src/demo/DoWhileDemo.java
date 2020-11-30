package demo;

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Doing something");
            System.out.println("Do you want to repeat?");
        } while (scanner.next().equals("yes"));

        int age;
        do {
            System.out.println("Enter your age");
            age = scanner.nextInt();
            System.out.println("You entered " + age);
        } while (age < 18);

        System.out.println("Good bye");
    }
}
