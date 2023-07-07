package Java;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Orders {

    private static final String STOCKFILE_PATH = "C:/uni files/cs112/src/TextFiles/stock.txt";
    private static final String PRODUCTDETAILSFILE_PATH = "C:/uni files/cs112/src/TextFiles/product_details.txt";

    public static void startOrder(){
        try (FileInputStream fileInputStream = new FileInputStream(STOCKFILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<Stock> stockArrayList = (ArrayList<Java.Stock>) objectInputStream.readObject();
            ArrayList<ProductDetails> productDetails = getProductDetails();
            float price = 0;

            System.out.println("Select a Location to Collect from: ");
            System.out.println("1. Glasgow");
            System.out.println("2. Edinburgh");
            System.out.println(" ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            System.out.println(" ");
            int count = 0;
            boolean confirmation = true;
            while (confirmation==true){
                float newPrice = getPrice(stockArrayList,scanner,choice,price,productDetails,count);
                price +=newPrice;
                System.out.print("Add another product? (y/n): ");
                Scanner confirmationScanner = new Scanner(System.in);
                String input = confirmationScanner.nextLine();
                if (input.equals("y")){confirmation=true;}
                else {confirmation=false;}
            }

            System.out.println("This order can be fulfilled and collected on ___. The total price is £" + price);
            System.out.println("Press any key to continue... ");
            System.out.println("");
            Scanner newScanner = new Scanner(System.in);
            newScanner.nextLine();



        } catch (Exception e) {
            System.out.println("Error occurred while displaying product details: " + e.getMessage());
        }

    }

    public static ArrayList<ProductDetails> getProductDetails(){
        try (FileInputStream fileInputStream = new FileInputStream(PRODUCTDETAILSFILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<ProductDetails> productDetailsList = (ArrayList<ProductDetails>) objectInputStream.readObject();
             return productDetailsList;

        } catch (Exception e) {
            System.out.println("Error occurred while displaying product details: " + e.getMessage());
            return null;
        }
    }

    private static float getPrice(ArrayList<Stock> stockArrayList, Scanner scanner, int choice, float price, ArrayList<ProductDetails> productDetails, int count){
        Scanner priceScanner = new Scanner(System.in);
        System.out.print("Enter the product ID: ");
        System.out.println(" ");
        String searchProductID = priceScanner.nextLine();
        boolean stockFound = false;
        for (Java.Stock stockList : stockArrayList) {
            if (stockList.getProductID().equals(searchProductID)) {
                System.out.println("Enter an amount");
                int amount = scanner.nextInt();
                if (choice==1){
                    int glasgowAmount = stockList.getGlasgow();
                    if (glasgowAmount>=amount){
                        price +=productDetails.get(count).getPrice();
                    } else {
                        if ((glasgowAmount+stockList.getGourock()+stockList.getEdinburgh())>=amount){
                            price +=productDetails.get(count).getPrice();

                        }
                    }
                }
                if (choice==2){
                    int edinburghAmount = stockList.getEdinburgh();
                    if (edinburghAmount>=amount){
                        price +=productDetails.get(count).getPrice();
                    } else {
                        if ((edinburghAmount+stockList.getGourock()+stockList.getGlasgow())>=amount){
                            price +=productDetails.get(count).getPrice();

                        }
                    }
                }
                stockFound=true;
            }
            count+=1;
        }
        if (!stockFound) {
            System.out.println("Product ID not found");
            System.out.println("Press any key to continue... ");
            System.out.println("");
            scanner.nextLine();
        }
        return price;
    }

}
