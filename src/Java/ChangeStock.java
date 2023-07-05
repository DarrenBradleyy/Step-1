package Java;

import Java.Main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static Java.Stock.FILE_PATH;

public class ChangeStock {


    enum Stock {
        Add,
        Deduct,
        Transfer,
        BACK
    }

    private static String Stock() {
        Scanner scanner = new Scanner(System.in);
        Stock stock;
        Boolean checked = false;

        do {
            System.out.println("Select Component Type to be added:");
            System.out.println("1. Add stock to a location");
            System.out.println("2. Deduct stock from location");
            System.out.println("3. Transfer stock");
            System.out.println("4. Main Menu");
            System.out.print("Enter an option: ");

            int choice = scanner.nextInt();
            stock = Stock.values()[choice - 1];

            switch (stock) {
                case Add:
                    System.out.println("You selected option 1");
                    System.out.println("");
                    addStock();
                case Deduct:
                    System.out.println("You selected option 2");
                    System.out.println("");
                    deductStock();
                case Transfer:
                    System.out.println("You selected option 3");
                    System.out.println("");
                    transferStock();
                case BACK:
                    System.out.println("Returning to Main Menu");
                    System.out.println("");
                    Main.restartProgram();

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);

    }

    private static void addStock(){


    }

    private static void deductStock(){

    }

    private static void transferStock(){

    }

    public static void getStock() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<Java.Stock> stockArrayList = (ArrayList<Java.Stock>) objectInputStream.readObject();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            String searchProductID = scanner.nextLine();

            boolean stockFound = false;

            for (Java.Stock stock : stockArrayList) {
                if (stock.getProductID().equals(searchProductID)) {
                    System.out.println("Stock:");
                    System.out.println("Glasgow: " + stock.getGlasgow());
                    System.out.println("Edinburgh: " + stock.getEdinburgh());
                    System.out.println("London: " + stock.getLondon());
                    System.out.println("Press any key to continue... ");
                    System.out.println("");
                    scanner.nextLine();
                    stockFound = true;
                    break;
                }
            }

            if (!stockFound) {
                System.out.println("Product ID not found");
                System.out.println("Press any key to continue... ");
                System.out.println("");
                scanner.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Error occurred while displaying product details: " + e.getMessage());
        }
    }
}

