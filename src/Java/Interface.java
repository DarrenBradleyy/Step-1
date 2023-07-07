//Registration No - 202201452
package Java;

import java.util.Scanner;

    public class Interface {

        private static String interfaceType;

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
        ITX
    }

    public static String interfaces(String component){
        //Check what the component type is
        if (component=="Motherboard"){
            //Set Interface for component
            interfaceType=CPU() +", "+GPU()+", "+Memory()+", "+Storage()+", "+PSU();
        }
        else if (component=="CPU"){
            interfaceType=CPU();
        } else if (component=="GPU") {
            interfaceType=GPU();
        }
        else if (component=="Memory") {
            interfaceType=Memory();
        }
        else if (component=="Storage") {
            interfaceType=Storage();
        }
        else if (component=="PSU") {
            interfaceType=PSU();
        }
        return interfaceType;

    }

    private static String CPU(){
        Scanner cpuScanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Interface Type:");
            System.out.println("1.SocketAM ");
            System.out.println("2.LGA");
            System.out.print("Select a Interface: ");

            int choice = cpuScanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
                case SocketAM:
                    System.out.println("You selected SocketAM");
                    System.out.println("");
                    return "SocketAM";
                case LGA:
                    System.out.println("You selected LGA");
                    System.out.println("");
                    return "LGA";

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);
    }


    private static String GPU(){
        System.out.println("You selected PCIe");
        System.out.println("");
        return "PCIe";
    }

    private static String Memory(){
        Scanner memoryScanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Interface Type:");
            System.out.println("4.DDR3 ");
            System.out.println("5.DDR4");
            System.out.println("6.DDR5");
            System.out.print("Select a Interface: ");

            int choice = memoryScanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
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

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);
    }

    private static String Storage(){
        Scanner storageScanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Interface Type:");
            System.out.println("7.NVME ");
            System.out.println("8.SATA");
            System.out.print("Select a Interface: ");

            int choice = storageScanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
                case NVME:
                    System.out.println("You selected NVME");
                    System.out.println("");
                    return "NVME";
                case SATA:
                    System.out.println("You selected SATA");
                    System.out.println("");
                    return "SATA";

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while(true);
    }

    private static String PSU(){
        Scanner psuScanner = new Scanner(System.in);
        Components components;
        Boolean checked = false;

        do {
            System.out.println("Select Interface Type:");
            System.out.println("9.ATX ");
            System.out.println("10.ITX");
            System.out.print("Select a Interface: ");

            int choice = psuScanner.nextInt();
            components = Components.values()[choice - 1];

            switch (components) {
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

