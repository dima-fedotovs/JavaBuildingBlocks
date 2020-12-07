package demo;

import java.util.*;

public class GuessNum {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<GameResult> leaderboard = new ArrayList<>();

    public static void main(String[] args) {

        String name;
        Random random = new Random();
        do {

            System.out.println("Enter your name:");
            name = scanner.next();

            int myNum = random.nextInt(100) + 1;
            System.out.println(myNum);
            System.out.println("I'm thinking a number from 1 to 100. Try to guess it!");
            long startTime = System.currentTimeMillis();
            boolean userWin = false;
            for (int attempt = 1; attempt <= 10; attempt++) {
                System.out.printf("Attempt #%d\n", attempt);
                int userNum = askNumber("Enter your guess", 1, 100);
                if (myNum > userNum) {
                    System.out.println("Your number is too low");
                } else if (myNum < userNum) {
                    System.out.println("Your number is too high");
                } else {
                    long endTime = System.currentTimeMillis();
                    GameResult gr = new GameResult();
                    gr.setName(name);
                    gr.setAttempts(attempt);
                    gr.setDuration(endTime - startTime);
                    leaderboard.add(gr);

                    System.out.printf("You won! %d attempts were used.\n", attempt);
                    userWin = true;
                    break;
                }
            }

            if (!userWin) {
                System.out.printf("You lost! My number was %d\n", myNum);
            }
            System.out.print("Do you want to play again? (Y/n) ");
        } while (!scanner.next().equals("n"));

        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        for (GameResult gr : leaderboard) {
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }

        System.out.println("Good bye!");
    }

    public static int askNumber(String msg, int min, int max) {
        while (true) {
            System.out.print(msg + ":> ");
            try {
                int result = scanner.nextInt();

                if (result < min) {
                    System.out.println("Number should not be less than " + min);
                    continue;
                }

                if (result > max) {
                    System.out.println("Number should not be greater than " + max);
                    continue;
                }

                return result;
            } catch (InputMismatchException e) {
                String input = scanner.next();
                System.out.println(input + " is not a number");
            }
        }
    }

}
