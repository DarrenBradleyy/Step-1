import java.util.Scanner;

public class Main {

    enum Options {
        NewComponent,
        Exit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Options selectedOption;

        do {
            System.out.println("Welcome to the OCP catalogue System");
            System.out.println("Enter an option below:");
            System.out.println("1. Add a new Component Product to Catalogue");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            selectedOption = Options.values()[choice - 1];

            switch (selectedOption) {
                case NewComponent:
                    System.out.println("You selected Option 1.");
                    System.out.println(" ");
                    String component = Component.component();
                    String interfaces = Interface.interfaces();
                    break;
                case Exit:
                    System.out.println("Exiting Menu");
                    // Perform actions for Option 2
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (selectedOption != Options.Exit);

        System.out.println("Menu system exited.");
        scanner.close();
    }
}

