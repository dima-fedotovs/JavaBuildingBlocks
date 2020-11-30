package demo;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt(100) + 1;

            System.out.println(r);
        }
    }
}
