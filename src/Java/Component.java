//Registration No - 202201452
package Java;

import java.util.Scanner;

public class Component {

    enum Components {
        CPU,
        GPU,
        Memory,
        Storage,
        PSU,
        Motherboard,
        BACK
    }

    public static String component() {
        Scanner scanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Component Type to be added:");
            System.out.println("1. CPU");
            System.out.println("2. GPU");
            System.out.println("3. Memory");
            System.out.println("4. Storage");
            System.out.println("5. PSU");
            System.out.println("6. Motherboard");
            System.out.println("7. Main Menu");
            System.out.print("Select a Component: ");

            //Get the Component type
            int choice = scanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
                case CPU:
                    System.out.println("You selected CPU");
                    System.out.println("");
                    return "CPU";
                case GPU:
                    System.out.println("You selected GPU");
                    System.out.println("");
                    return "GPU";
                case Memory:
                    System.out.println("You selected Memory");
                    System.out.println("");
                    return "Memory";
                case Storage:
                    System.out.println("You selected Storage");
                    System.out.println("");
                    return "Storage";
                case PSU:
                    System.out.println("You selected PSU");
                    System.out.println("");
                    return "PSU";
                case Motherboard:
                    System.out.println("You selected Motherboard");
                    System.out.println("");
                    return "Motherboard";
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
}

