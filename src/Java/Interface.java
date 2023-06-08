package Java;

import java.util.Scanner;

    public class Interface {

    enum Components {
        SocketAM,
        LGA,
        PCIe,
        DDR3,
        DDR4,
        DDR5,
        NVME,
        SATA,
        ATX,
        ITX,
    }

    public static String interfaces() {
        Scanner scanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Interface Type:");
            System.out.println("1.SocketAM ");
            System.out.println("2.PCIe ");
            System.out.println("3.DDR3 ");
            System.out.println("4.DDR4 ");
            System.out.println("5.DDR5 ");
            System.out.println("6.NVME ");
            System.out.println("7.SATA ");
            System.out.println("8.ATX ");
            System.out.println("9.ITX ");
            System.out.print("Select a Interface: ");

            int choice = scanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
                case SocketAM:
                    System.out.println("You selected SocketAM");
                    System.out.println("");
                    return "SocketAM";
                case PCIe:
                    System.out.println("You selected PCIe");
                    System.out.println("");
                    return "PCIe";
                case DDR3:
                    System.out.println("You selected DDR3");
                    System.out.println("");
                    return "DDR3";
                case DDR4:
                    System.out.println("You selected DDR4");
                    System.out.println("");
                    return "DDR4";
                case DDR5:
                    System.out.println("You selected DDR5");
                    System.out.println("");
                    return "DDR5";
                case NVME:
                    System.out.println("You selected NVME");
                    System.out.println("");
                    return "NVME";
                case SATA:
                    System.out.println("You selected SATA");
                    System.out.println("");
                    return "SATA";
                case ATX:
                    System.out.println("You selected ATX");
                    System.out.println("");
                    return "ATX";
                case ITX:
                    System.out.println("You selected ITX");
                    System.out.println("");
                    return "ITX";

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);

    }
}

