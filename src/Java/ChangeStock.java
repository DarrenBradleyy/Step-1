package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ChangeStock {

    //private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/stock.txt";
    private static final String FILE_PATH = "C:/Uni work/term 3/cs 112 project/Step4/src/TextFiles/stock.txt";
    private static int amount;
    private static int transferLocation;

    enum Stock {
        Add,
        Deduct,
        Transfer,
        BACK
    }

    enum Location {
        Glasgow,
        Edinburgh,
        Gourock,
        BACK
    }

    private static void changeStock(Java.Stock stockLevels, int count) {
        Scanner scanner = new Scanner(System.in);
        Stock stock;
        Boolean checked = false;

        //Get user input about change stock options
        do {
            System.out.println("Select Option:");
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
                    addStock(stockLevels,count);
                case Deduct:
                    System.out.println("You selected option 2");
                    System.out.println("");
                    deductStock(stockLevels,count);
                case Transfer:
                    System.out.println("You selected option 3");
                    System.out.println("");
                    transferStock(stockLevels,count);
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

    private static void addStock(Java.Stock stockLevels, int count){
        Scanner scanner = new Scanner(System.in);
        Location location;
        Boolean checked = false;

        //Get location to add stock to
        do {
            System.out.println("Select Location:");
            System.out.println("1. Glasgow");
            System.out.println("2. Edinburgh");
            System.out.println("3. Gourock");
            System.out.println("4. Main Menu");
            System.out.print("Enter an option: ");

            int choice = scanner.nextInt();
            location = Location.values()[choice - 1];

            //Change stock levels
            switch (location) {
                case Glasgow:
                    System.out.println("You selected Glasgow");
                    System.out.println("");
                    System.out.println("Enter amount to add:");
                    amount =scanner.nextInt();
                    int glasgowAmount = stockLevels.getGlasgow();
                    stockLevels.setGlasgow(amount+glasgowAmount);
                    System.out.println("Glasgow now has "+ stockLevels.getGlasgow()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;

                case Edinburgh:
                    System.out.println("You selected Edinburgh");
                    System.out.println("");
                    System.out.println("Enter amount to add:");
                    amount =scanner.nextInt();
                    int edinburghAmount = stockLevels.getEdinburgh();
                    stockLevels.setEdinburgh(amount+edinburghAmount);
                    System.out.println("Edinburgh now has "+ stockLevels.getEdinburgh()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case Gourock:
                    System.out.println("You selected Gourock");
                    System.out.println("");
                    System.out.println("Enter amount to add:");
                    amount =scanner.nextInt();
                    int gourockAmount = stockLevels.getGourock();
                    stockLevels.setGourock(amount+gourockAmount);
                    System.out.println("Gourock now has "+ stockLevels.getGourock()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case BACK:
                    System.out.println("Returning to Main Menu");
                    System.out.println("");
                    Main.restartProgram();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);


    }

    private static void deductStock(Java.Stock stockLevels, int count){
        Scanner scanner = new Scanner(System.in);
        Location location;
        Boolean checked = false;

        //Get location to deduct stock from
        do {
            System.out.println("Select Location:");
            System.out.println("1. Glasgow");
            System.out.println("2. Edinburgh");
            System.out.println("3. Gourock");
            System.out.println("4. Main Menu");
            System.out.print("Enter an option: ");

            int choice = scanner.nextInt();
            location = Location.values()[choice - 1];

            //Change stock levels
            switch (location) {
                case Glasgow:
                    System.out.println("You selected Glasgow");
                    System.out.println("");
                    System.out.println("Enter amount to deduct:");
                    amount =scanner.nextInt();
                    int glasgowAmount = stockLevels.getGlasgow();
                    stockLevels.setGlasgow(glasgowAmount-amount);
                    System.out.println("Glasgow now has "+ stockLevels.getGlasgow()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;

                case Edinburgh:
                    System.out.println("You selected Edinburgh");
                    System.out.println("");
                    System.out.println("Enter amount to deduct:");
                    amount =scanner.nextInt();
                    int edinburghAmount = stockLevels.getEdinburgh();
                    stockLevels.setEdinburgh(edinburghAmount-amount);
                    System.out.println("Edinburgh now has "+ stockLevels.getEdinburgh()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case Gourock:
                    System.out.println("You selected Gourock");
                    System.out.println("");
                    System.out.println("Enter amount to deduct:");
                    amount =scanner.nextInt();
                    int gourockAmount = stockLevels.getGourock();
                    stockLevels.setEdinburgh(gourockAmount-amount);
                    System.out.println("Gourock now has "+ stockLevels.getGourock()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case BACK:
                    System.out.println("Back");
                    System.out.println("");
                    Main.restartProgram();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);


    }

    private static void transferStock(Java.Stock stockLevels, int count){
        Scanner scanner = new Scanner(System.in);
        Location location;
        Boolean checked = false;
        int glasgowAmount = stockLevels.getGlasgow();
        int edinburghAmount = stockLevels.getEdinburgh();
        int gourockAmount = stockLevels.getGourock();

        //Get location to transfer stock from
        do {
            System.out.println("Select Location to transfer from:");
            System.out.println("1. Glasgow");
            System.out.println("2. Edinburgh");
            System.out.println("3. Gourock");
            System.out.println("4. Main Menu");
            System.out.print("Enter an option: ");

            int choice = scanner.nextInt();
            location = Location.values()[choice - 1];


            //Select location to add stock to
            switch (location) {
                case Glasgow:
                    System.out.println("You selected Glasgow");
                    System.out.println("");
                    System.out.println("Select a location to transfer to:");
                    System.out.println("1. Edinburgh    2. Gourock");
                    transferLocation = scanner.nextInt();
                    System.out.println("Enter amount to transfer:");
                    amount =scanner.nextInt();
                    if (transferLocation ==1 && glasgowAmount>=amount){
                        stockLevels.setEdinburgh(edinburghAmount+amount);
                        stockLevels.setGlasgow(glasgowAmount-amount);
                        System.out.println("Edinburgh now has "+ stockLevels.getEdinburgh()+ " of this item available");
                    }
                    else if (transferLocation ==2 && glasgowAmount>=amount){
                        stockLevels.setGlasgow(gourockAmount+amount);
                        stockLevels.setGlasgow(glasgowAmount-amount);
                        System.out.println("Gourock now has "+ stockLevels.getGourock()+ " of this item available");
                    }
                    System.out.println("Glasgow now has "+ stockLevels.getGlasgow()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;

                case Edinburgh:
                    System.out.println("You selected Edinburgh");
                    System.out.println("");
                    System.out.println("Select a location to transfer to:");
                    System.out.println("1. Glasgow    2. Gourock");
                    transferLocation = scanner.nextInt();
                    System.out.println("Enter amount to transfer:");
                    amount =scanner.nextInt();
                    if (transferLocation ==1 && edinburghAmount>=amount){
                        stockLevels.setEdinburgh(edinburghAmount-amount);
                        stockLevels.setGlasgow(glasgowAmount+amount);
                        System.out.println("Glasgow now has "+ stockLevels.getGlasgow()+ " of this item available");
                    }
                    else if (transferLocation ==2 && edinburghAmount>=amount){
                        stockLevels.setGlasgow(gourockAmount+amount);
                        stockLevels.setGlasgow(edinburghAmount-amount);
                        System.out.println("Gourock now has "+ stockLevels.getGourock()+ " of this item available");
                    }
                    System.out.println("Edinburgh now has "+ stockLevels.getEdinburgh()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case Gourock:
                    System.out.println("You selected Gourock");
                    System.out.println("");
                    System.out.println("Select a location to transfer to:");
                    System.out.println("1. Edinburgh    2. Glasgow");
                    transferLocation = scanner.nextInt();
                    System.out.println("Enter amount to transfer:");
                    amount =scanner.nextInt();
                    if (transferLocation ==2 && gourockAmount>=amount){
                        stockLevels.setGourock(gourockAmount-amount);
                        stockLevels.setGlasgow(glasgowAmount+amount);
                        System.out.println("Glasgow now has "+ stockLevels.getGlasgow()+ " of this item available");
                    }
                    else if (transferLocation ==1 && edinburghAmount>=amount){
                        stockLevels.setGlasgow(gourockAmount-amount);
                        stockLevels.setGlasgow(edinburghAmount+amount);
                        System.out.println("Edinburgh now has "+ stockLevels.getEdinburgh()+ " of this item available");
                    }
                    System.out.println("Gourock now has "+ stockLevels.getGourock()+ " of this item available");
                    updateStock(count,stockLevels);
                    break;
                case BACK:
                    System.out.println("Back");
                    System.out.println("");
                    Main.restartProgram();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);


    }

    public static void getStock() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<Java.Stock> stockArrayList = (ArrayList<Java.Stock>) objectInputStream.readObject();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            String searchProductID = scanner.nextLine();
            int count = 0;

            boolean stockFound = false;

            for (Java.Stock stockList : stockArrayList) {
                if (stockList.getProductID().equals(searchProductID)) {
                   changeStock(stockList,count);
                   stockFound=true;
                }
                count += 1;
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

    private static void updateStock(int index, Java.Stock stockLevels) {
        try {
            ArrayList<Java.Stock> savedStockList;

            File file = new File(FILE_PATH);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                try {
                    savedStockList = (ArrayList<Java.Stock>) objectInputStream.readObject();
                } catch (EOFException | ClassNotFoundException e) {
                    savedStockList = new ArrayList<>();
                }

                objectInputStream.close();
                fileInputStream.close();
            } else {
                savedStockList = new ArrayList<>();
            }

            savedStockList.set(index,stockLevels);

            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(savedStockList);
            objectOutputStream.close();
            fileOutputStream.close();


            System.out.println("Stock saved to stock.txt.");
        } catch (Exception e) {
            System.out.println("Error occurred while saving stock: " + e.getMessage());
        }
    }

}

