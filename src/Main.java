import app.DeliveryApplication;
import transport.Logistics;
import transport.RoadLogistics;
import transport.SeaLogistics;
import ui.GUIFactory;
import ui.MacOSFactory;
import ui.WindowsFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String deliveryModeInput = null;
        String uiPlatformInput = null;

        if (args.length >= 2) {
            deliveryModeInput = args[0];
            uiPlatformInput = args[1];
        } else if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter delivery mode (ROAD / SEA): ");
            if (scanner.hasNextLine()) {
                deliveryModeInput = scanner.nextLine().trim();
            }
            System.out.print("Enter UI platform (WINDOWS / MACOS): ");
            if (scanner.hasNextLine()) {
                uiPlatformInput = scanner.nextLine().trim();
            }
        } else {
            System.out.println("Error: Insufficient arguments provided. Please supply both delivery mode and UI platform.");
            return;
        }

        if (deliveryModeInput == null || deliveryModeInput.isEmpty() || uiPlatformInput == null || uiPlatformInput.isEmpty()) {
            System.out.println("Error: Input parameters cannot be empty or missing.");
            return;
        }

        Logistics logistics = selectLogistics(deliveryModeInput);
        if (logistics == null) {
            System.out.println("Error: Unsupported delivery mode '" + deliveryModeInput + "'. Supported modes are ROAD and SEA.");
            return;
        }

        GUIFactory guiFactory = selectGUIFactory(uiPlatformInput);
        if (guiFactory == null) {
            System.out.println("Error: Unsupported UI platform '" + uiPlatformInput + "'. Supported platforms are WINDOWS and MACOS.");
            return;
        }

        System.out.println("Delivery mode: " + deliveryModeInput.toUpperCase());
        System.out.println("UI platform: " + uiPlatformInput.toUpperCase());

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run("laboratory equipment", "Aktau warehouse");
    }

    private static Logistics selectLogistics(String mode) {
        if ("ROAD".equalsIgnoreCase(mode)) {
            return new RoadLogistics();
        } else if ("SEA".equalsIgnoreCase(mode)) {
            return new SeaLogistics();
        }
        return null;
    }

    private static GUIFactory selectGUIFactory(String platform) {
        if ("WINDOWS".equalsIgnoreCase(platform)) {
            return new WindowsFactory();
        } else if ("MACOS".equalsIgnoreCase(platform)) {
            return new MacOSFactory();
        }
        return null;
    }
}