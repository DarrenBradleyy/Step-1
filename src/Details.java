import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Details {

    private static final int SERIAL_NUMBER_LENGTH = 4;
    private static final int MAX_SERIAL_NUMBER = 9999;
    private static Map<String, Integer> usedSerialNumbers = new HashMap<>();
    private ProductCatalogue productCatalogue = new ProductCatalogue();

    public void details(String component, String interfaces) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the details for the component: ");

        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        float price = Float.parseFloat(scanner.nextLine());

        String manufacturerCode = manufacturer.substring(0, Math.min(manufacturer.length(), 4)).toUpperCase();
        String serialNumber = getNextSerialNumber(manufacturerCode);
        String paddedSerialNumber = String.format("%0" + SERIAL_NUMBER_LENGTH + "d", Integer.parseInt(serialNumber));
        String productID = manufacturerCode+paddedSerialNumber;


        System.out.println("Product is "+ component+ " " + description + " with interface "+interfaces+ " manufactured by "
                + manufacturer + " at price "+ price);

        System.out.print("Are these inputs correct? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Product ID " + productID + " added to catalogue");
            productCatalogue.writeToCatalogue(productID);
            System.out.println("Press any key to continue... ");
            System.out.println("");
            scanner.nextLine();
            scanner.close();
            new Main();

        } else {
            System.out.println("Inputs not confirmed. Please try again.");
            new Main();
        }

        scanner.close();
    }

    private static String getNextSerialNumber(String manufacturerCode) {
        int serialNumber = usedSerialNumbers.getOrDefault(manufacturerCode, 0) + 1;
        usedSerialNumbers.put(manufacturerCode, serialNumber);
        return String.valueOf(serialNumber);
    }
}




