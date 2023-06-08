package Java;

import java.util.Scanner;

public class Main {

    enum Options {
        NewComponent,
        Exit
    }

    private static final Scanner scanner = new Scanner(System.in); // Declare Scanner as a class variable

    public static void main(String[] args) {
        boolean continues = menu();
        if (continues)
        restartProgram();
    }

    private static int askForNumber(String prompt) {
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // Consume the invalid input
        }

        int number = scanner.nextInt();
        return number;
    }

    private static void restartProgram() {
        main(new String[0]);
    }

    private static boolean menu(){
        Options selectedOption;
        boolean continueLoop = true; // Flag variable for loop continuation
        do {
            System.out.println("Welcome to the OCP catalogue System");
            System.out.println("Enter an option below:");
            System.out.println("1. Add a new Java.Component Product to Catalogue");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = askForNumber("Select an option: ");
            selectedOption = Options.values()[choice - 1];

            switch (selectedOption) {
                case NewComponent:
                    System.out.println("You selected Option 1.");
                    System.out.println(" ");
                    String component = Component.component();
                    String interfaces = Interface.interfaces();
                    Details.details(component, interfaces);
                    return true;
                case Exit:
                    System.out.println("Exiting Menu");
                    System.out.println(" ");
                    System.out.println("Menu system exited.");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (continueLoop); // Use the flag variable to control the loop continuation
        return false;
    }
}
