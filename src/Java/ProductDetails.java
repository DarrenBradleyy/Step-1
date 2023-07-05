package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductDetails implements Serializable {
    //private static final String FILE_PATH = "C:/Uni work/term 3/cs 112 project/Step2/src/TextFiles/product_details.txt";
    private static final String FILE_PATH = "C:/uni files/cs112/src/TextFiles/product_details.txt";
    private static ArrayList<ProductDetails> productDetailsList = new ArrayList<>();

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
        try {
            ArrayList<ProductDetails> savedProductDetails;

            File file = new File(FILE_PATH);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                try {
                    savedProductDetails = (ArrayList<ProductDetails>) objectInputStream.readObject();
                } catch (EOFException | ClassNotFoundException e) {
                    savedProductDetails = new ArrayList<>();
                }

                objectInputStream.close();
                fileInputStream.close();
            } else {
                savedProductDetails = new ArrayList<>();
            }

            savedProductDetails.add(this);

            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(savedProductDetails);
            objectOutputStream.close();
            fileOutputStream.close();

            productDetailsList = savedProductDetails;

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
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            ArrayList<ProductDetails> productDetailsList = (ArrayList<ProductDetails>) objectInputStream.readObject();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            String searchProductID = scanner.nextLine();

            boolean productFound = false;

            for (ProductDetails product : productDetailsList) {
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
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
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
