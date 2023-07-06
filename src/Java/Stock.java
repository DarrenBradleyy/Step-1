package Java;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Stock implements Serializable {
    private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/stock.txt";
    private static ArrayList<Stock> stockList = new ArrayList<>();

    private String productID;
    private int glasgow;
    private int edinburgh;
    private int gourock;

    public Stock(String productID, int glasgow, int edinburgh, int gourock) {
        this.productID = productID;
        this.glasgow = glasgow;
        this.edinburgh = edinburgh;
        this.gourock = gourock;
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
                    System.out.println("Gourock: " + stock.getGourock());
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

    public void setGlasgow(int glasgow) {
        this.glasgow = glasgow;
    }

    public void setEdinburgh(int edinburgh) {
        this.edinburgh = edinburgh;
    }

    public void setGourock(int gourock) {
        this.gourock = gourock;
    }

    public int getGlasgow() {
        return glasgow;
    }

    public int getEdinburgh() {
        return edinburgh;
    }

    public int getGourock() {
        return gourock;
    }
}

