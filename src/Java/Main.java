package Java;

import java.util.Scanner;

public class Main {


    enum Options {
        NewComponent,
        ProductID,
        ProductDetails,
        CheckStock,
        ChangeStock,
        OrderFulfillment,
        Exit
    }

    static final Scanner scanner = new Scanner(System.in); // Declare Scanner as a class variable

    public static void main(String[] args) {
        boolean continues = menu();
        if (continues)
        restartProgram();
    }

    public static int askForNumber() {
        

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
        }

        int number = scanner.nextInt();
        if (number<=0|| number>4){
            System.out.println("Enter valid input");
            number = scanner.nextInt();
        }
        return number;
    }

    public static void restartProgram() {
        main(new String[0]);
    }

    public static boolean menu(){
        Options selectedOption;
        boolean continueLoop = true;
        do {
            System.out.println("Welcome to the OCP catalogue System");
            System.out.println("Enter an option below:");
            System.out.println("1. Add a new Component Product to Catalogue");
            System.out.println("2. View all product IDs");
            System.out.println("3. View all product Details");
            System.out.println("4. Check product stock levels");
            System.out.println("5. Change product stock levels");
            System.out.println("6. Order Fulfillment");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = askForNumber();
            selectedOption = Options.values()[choice - 1];

            switch (selectedOption) {
                case NewComponent:
                    System.out.println("You selected Option 1.");
                    System.out.println(" ");
                    String component = Component.component();
                    String interfaces = Interface.interfaces(component);
                    Details.details(component, interfaces);
                    return true;
                case ProductID:
                    System.out.println("You selected Option 2.");
                    System.out.println(" ");
                    ProductID.displayProductIDs();
                    return true;
                case ProductDetails:
                    System.out.println("You selected Option 3.");
                    System.out.println(" ");
                    ProductDetails.displayProductDetails();
                    return true;
                case CheckStock:
                    System.out.println("You selected Option 4.");
                    System.out.println(" ");
                    Stock.displayStockLevels();
                    return true;
                case ChangeStock:
                    System.out.println("You selected Option 5.");
                    System.out.println(" ");
                    ChangeStock.getStock();
                    return true;
                case OrderFulfillment:
                    System.out.println("You selected Option 6.");
                    System.out.println(" ");
                    Orders.startOrder();
                    return true;
                case Exit:
                    System.out.println("Exiting Menu");
                    System.out.println(" ");
                    System.out.println("Menu system exited.");
                    System.exit(0);
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (continueLoop);
        return false;
    }
}
