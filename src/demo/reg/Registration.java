package demo.reg;


import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        ArrayList<RegistrationForm> regs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("New registration");
            RegistrationForm frm = new RegistrationForm();

            System.out.println("Name: ");
            frm.fullName = scanner.next();

            System.out.println("age: ");
            frm.age = scanner.nextInt();

            System.out.println("phone");
            frm.phone = scanner.next();

            regs.add(frm);

            System.out.println("Add more?");
            if (scanner.next().equals("no")) {
                break;
            }
        }

        for (RegistrationForm reg : regs) {
            System.out.printf("name: %s; phone:%s; age:%d\n", reg.fullName, reg.phone, reg.age);
        }
    }
}
