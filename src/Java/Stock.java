package Java;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Stock implements Serializable {
    static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/stock.txt";
    private static ArrayList<Stock> stockList = new ArrayList<>();

    private String productID;
    private String glasgow;
    private String edinburgh;
    private String london;

    public Stock(String productID, String glasgow, String edinburgh, String london) {
        this.productID = productID;
        this.glasgow = glasgow;
        this.edinburgh = edinburgh;
        this.london = london;
    }

    public void writeStockLevels() {
        try {
            ArrayList<Stock> savedStockList;

            File file = new File(FILE_PATH);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                try {
                    savedStockList = (ArrayList<Stock>) objectInputStream.readObject();
                } catch (EOFException | ClassNotFoundException e) {
                    savedStockList = new ArrayList<>();
                }

                objectInputStream.close();
                fileInputStream.close();
            } else {
                savedStockList = new ArrayList<>();
            }

            savedStockList.add(this);

            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(savedStockList);
            objectOutputStream.close();
            fileOutputStream.close();

            stockList = savedStockList;

            System.out.println("Stock saved to stock.txt.");
        } catch (Exception e) {
            System.out.println("Error occurred while saving stock: " + e.getMessage());
        }
    }

    public static void displayStockLevels() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<Stock> stockArrayList = (ArrayList<Stock>) objectInputStream.readObject();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            String searchProductID = scanner.nextLine();

            boolean stockFound = false;

            for (Stock stock : stockArrayList) {
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


    public String getProductID() {
        return productID;
    }

    public String getGlasgow() {
        return glasgow;
    }

    public String getEdinburgh() {
        return edinburgh;
    }

    public String getLondon() {
        return london;
    }
}

