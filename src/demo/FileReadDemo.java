package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo {
    public static void main(String[] args) {
        var file = new File("test.txt");
        try (var in = new Scanner(file)) {
            while(in.hasNextLine()) {
                var line = in.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
        }
    }
}
