package Java;

import java.io.*;
import java.util.Scanner;

import static Java.Main.scanner;

public class ProductDetails implements Serializable {
    private String productID;
    private String component;
    private String interfaces;
    private String manufacturer;
    private String description;
    private float price;

    public ProductDetails(String productID, String component, String interfaces, String manufacturer,
                          String description, float price) {
        this.productID = productID;
        this.component = component;
        this.interfaces = interfaces;
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
    }

    public void saveProductDetails() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:/uni files/cs112/src/TextFiles/product_details.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(this);
            System.out.println("Product details saved to product_details.txt.");

        } catch (Exception e) {
            System.out.println("Error occurred while saving product details: " + e.getMessage());
        }
    }

    public String getProductID() {
        return productID;
    }

    public String getComponent() {
        return component;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public static void displayProductDetails() {
        try (FileInputStream fileInputStream = new FileInputStream("C:/uni files/cs112/src/TextFiles/product_details.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            String searchProductID = scanner.nextLine();

            while (true) {
                ProductDetails product = (ProductDetails) objectInputStream.readObject();

                if (product == null) {
                    System.out.println("Product ID not found.");
                    break;
                }

                if (product.getProductID().equals(searchProductID)) {
                    System.out.println("Product Details:");
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Component: " + product.getComponent());
                    System.out.println("Interfaces: " + product.getInterfaces());
                    System.out.println("Manufacturer: " + product.getManufacturer());
                    System.out.println("Description: " + product.getDescription());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Press any key to continue... ");
                    System.out.println("");
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Product ID not found");
                    System.out.println("Press any key to continue... ");
                    System.out.println("");
                    scanner.nextLine();
                }
            }
        } catch (Exception e) {
        }
    }

}
