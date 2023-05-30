import java.util.Scanner;

public class Component {

    enum Components {
        CPU,
        GPU,
        Memory,
        Storage,
        PSU,
        BACK
    }

    public static String component() {
        Scanner scanner = new Scanner(System.in);
        Components components;

        do {
            System.out.println("Option 1 Menu:");
            System.out.println("1. CPU");
            System.out.println("2. GPU");
            System.out.println("3. Memory");
            System.out.println("4. Storage");
            System.out.println("5. PSU");
            System.out.println("0. Back");
            System.out.print("Select a Component: ");

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
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (components != Components.BACK);

        scanner.close();
        return "";
    }
}

