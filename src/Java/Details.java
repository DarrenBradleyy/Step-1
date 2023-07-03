package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Details {

    private static final int SERIAL_NUMBER_LENGTH = 8;
    private static final int MAX_SERIAL_NUMBER = 99999999;
    private static Map<String, Integer> usedSerialNumbers = new HashMap<>();
    private static ProductCatalogue productCatalogue = new ProductCatalogue();
    private static int[] stockLevels = {0,0,0};

    public static void details(String component, String interfaces) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details for the component: ");

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        float price = Float.parseFloat(scanner.nextLine());

        String manufacturerCode = padManufacturerCode(manufacturer);
        String serialNumber = getNextSerialNumber(manufacturerCode);
        String paddedSerialNumber = String.format("%04d", Integer.parseInt(serialNumber));
        String productID = manufacturerCode + paddedSerialNumber;


        System.out.println("Product is " + component + " " + description + " with interface " + interfaces + " manufactured by "
                + manufacturer + " at price " + price);

        System.out.print("Are these inputs correct? (y/n): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("y")) {
            System.out.println("Product ID " + productID + " added to catalogue");
            productCatalogue.writeToCatalogue(productID);
            ProductDetails productDetails = new ProductDetails(productID, component, interfaces, manufacturer, description, price);
            productDetails.saveProductDetails();
            productDetails.writeStockLevels(stockLevels);
            System.out.println("Press any key to continue... ");
            System.out.println("");
            scanner.nextLine();

        } else {
            System.out.println("Inputs not confirmed. Please try again.");

        }
    }

    private static String padManufacturerCode(String manufacturer) {
        String paddedManufacturerCode = manufacturer.substring(0, Math.min(manufacturer.length(), 4)).toUpperCase();
        paddedManufacturerCode = String.format("%-4s", paddedManufacturerCode).replace(' ', 'x');
        return paddedManufacturerCode;
    }

    private static String getNextSerialNumber(String manufacturerCode) {
        int serialNumber = usedSerialNumbers.getOrDefault(manufacturerCode, 0) + 1;
        usedSerialNumbers.put(manufacturerCode, serialNumber);
        return String.valueOf(serialNumber);
    }
}
