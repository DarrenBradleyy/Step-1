package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ProductID {
    //private static final String FILE_PATH = "C:/Uni work/term 3/cs 112 project/Step-1/TextFiles/product_codes.txt";
    private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/product_codes.txt";
    static Scanner scanner = new Scanner(System.in);


    public static void displayProductIDs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Press any key to continue... ");
            System.out.println("");
            scanner.nextLine();
        } catch (IOException e) {
            System.out.println("Error reading the catalogue file.");
        }
    }
}
