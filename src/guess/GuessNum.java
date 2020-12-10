package guess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class GuessNum {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<GameResult> leaderboard = new ArrayList<>();
    private static File leaderboardFile = new File("leaderboard.txt");

    public static void main(String[] args) {
        loadLeaderboard();

        String name;
        Random random = new Random();

        boolean answer;
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
                int userNum = askUserNumber("Enter your guess", 1, 100);
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
            answer = scanner.next().equals("n");

        } while (!answer);

        saveLeaderboard();
        printLeaderboard5();

        System.out.println("Good bye!");
    }

    private static void loadLeaderboard() {
        try (var in = new Scanner(leaderboardFile)) {
            while (in.hasNext()) {
                var gr = new GameResult();
                gr.setName(in.next());
                gr.setAttempts(in.nextInt());
                gr.setDuration(in.nextLong());
                leaderboard.add(gr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read leaderboard");
        }
    }

    private static void saveLeaderboard() {
        try(var out = new PrintWriter(leaderboardFile)) {
            for (GameResult gr : leaderboard) {
                out.printf("%s %d %d\n", gr.getName(), gr.getAttempts(), gr.getDuration());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save leaderboard");
        }
    }

    private static void printLeaderboard() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        for (GameResult gr : leaderboard) {
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }

    private static void printLeaderboard2() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        var rows = 5;
        for (GameResult gr : leaderboard) {
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
            if (--rows == 0) {
                break;
            }
        }
    }

    private static void printLeaderboard3() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        var num = Math.min(5, leaderboard.size());
        var sublist = leaderboard.subList(0, num);
        for (GameResult gr : sublist) {
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }

    private static void printLeaderboard4() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        for (int i = 0; i < 5 && i < leaderboard.size(); i++) {
            var gr = leaderboard.get(i);
            System.out.printf("%d. %s \t %d \t %.1f \n", i+1, gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }

    public static void printLeaderboard5() {
        leaderboard.stream()
                .sorted(
                        Comparator
                                .comparingInt(GameResult::getAttempts)
                                .thenComparingLong(GameResult::getDuration)
                )
                .limit(5)
                .forEach(gr -> {
                    System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
                });
    }



    public static int askUserNumber(String message, int min, int max) {
        while (true) {
            String msg = message + ":> ";
            System.out.print(msg);
            try {
                int r = scanner.nextInt();

                if (r < min) {
                    System.out.println("Number should not be less than " + min);
                    continue;
                }

                if (r > max) {
                    System.out.println("Number should not be greater than " + max);
                    continue;
                }

                return r;
            } catch (InputMismatchException e) {
                String input = scanner.next();
                System.out.println(input + " is not a number");
            }
        }
    }

}
