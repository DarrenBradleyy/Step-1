package Java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductCatalogue {
    //private static final String FILE_PATH = "C:/Uni work/term 3/cs 112 project/Step2/src/TextFiles/product_codes.txt";
    private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/product_codes.txt";


    public void writeToCatalogue(String productID){
        saveProductCodeToFile(productID);
    }

    private static void saveProductCodeToFile(String productCode) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_PATH, true)))) {
            out.println(productCode);
            System.out.println("Product code saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving product code to file: " + e.getMessage());
        }
    }

}
