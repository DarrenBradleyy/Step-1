//Registration No - 202201452
package Java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Details {

    private static final String FILE_PATH = "C:/Uni work/term 3/cs 112 project/Step4/src/TextFiles/product_details.txt";
    //private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/product_details.txt";
    private static final int SERIAL_NUMBER_LENGTH = 8;
    private static final int MAX_SERIAL_NUMBER = 99999999;
    private static Map<String, Integer> usedSerialNumbers = new HashMap<>();
    private static ProductCatalogue productCatalogue = new ProductCatalogue();
    private static ArrayList<String> stockLevels = new ArrayList<>();

    public static void details(String component, String interfaces) {

        //Get Specific details from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details for the component: ");

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        float price = Float.parseFloat(scanner.nextLine());

        //Set product ID and check if exists in product details already
        String manufacturerCode = padManufacturerCode(manufacturer);
        String serialNumber = getNextSerialNumber(manufacturerCode);
        String paddedSerialNumber = String.format("%04d", Integer.parseInt(serialNumber));
        String productID = manufacturerCode + paddedSerialNumber;

        System.out.println("Product is " + component + " " + description + " with interface " + interfaces + " manufactured by "
                + manufacturer + " at price " + price);

        //Check if details are correct
        System.out.print("Are these inputs correct? (y/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            System.out.println("Product ID " + productID + " added to catalogue");
            //Write to product_codes.txt
            productCatalogue.writeToCatalogue(productID);
            ProductDetails productDetails = new ProductDetails(productID, component, interfaces, manufacturer, description, price);
            //Write to product_details.txt
            productDetails.saveProductDetails();
            Stock stock = new Stock(productID, 0, 0, 0);
            //Write to stock.txt
            stock.writeStockLevels();
            System.out.println("Press any key to continue... ");
            System.out.println("");
            scanner.nextLine();

        } else {
            System.out.println("Inputs not confirmed. Please try again.");

        }
    }

    public static String padManufacturerCode(String manufacturer) {
        String paddedManufacturerCode = manufacturer.substring(0, Math.min(manufacturer.length(), 4)).toUpperCase();
        paddedManufacturerCode = String.format("%-4s", paddedManufacturerCode).replace(' ', 'x');
        return paddedManufacturerCode;
    }

    private static String getNextSerialNumber(String manufacturerCode) {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<ProductDetails> productDetails = (ArrayList<ProductDetails>) objectInputStream.readObject();
            int serialNumber = 1;
            if (productDetails.isEmpty()){
                return String.valueOf(serialNumber);
            }
            for (ProductDetails product : productDetails) {
                String productID = product.getProductID();
                if (productID.contains(manufacturerCode)) {
                    return String.valueOf(serialNumber += 1);
                }
            }
            return String.valueOf(serialNumber);
        } catch (IOException e) {
            return String.valueOf(1);
        } catch (ClassNotFoundException e) {
            return String.valueOf(1);
        }
    }
}
