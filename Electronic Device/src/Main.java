import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of devices (1-20): ");
        int numDevices = scanner.nextInt();

        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid input.");
            return;
        }

        ArrayList<Device> devices = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numDevices; i++) {
            String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
            String randomType = deviceTypes[random.nextInt(deviceTypes.length)];
            double randomPrice = 100 + random.nextDouble() * 2000;
            double randomWeight = 100 + random.nextDouble() * 1000;

            if (randomType.equals("Smartphone")) {
                double randomScreenSize = random.nextDouble() ;
                int randomCameraResolution = random.nextInt();
                devices.add(new Smartphone(randomType, randomPrice, randomWeight, randomScreenSize, randomCameraResolution));

            } else if (randomType.equals("Laptop")) {
                String[] drives = {"SSD", "HDD"};
                String randomDrives = drives[random.nextInt(drives.length)];
                int randomRam = random.nextInt();
                devices.add(new Laptop(randomType, randomPrice, randomWeight, randomDrives, randomRam));
            } else if (randomType.equals("Tablet")) {
                String[] operatingSystems = {"Android", "iOS"};
                String randomOS = operatingSystems[random.nextInt(operatingSystems.length)];
                double randomScreenSize = random.nextDouble() ;
                devices.add(new Tablet(randomType, randomPrice, randomWeight, randomOS, randomScreenSize));
            }
        }

        int numDistinctTypes = 0;
        double totalPrice = 0.0;
        double totalWeight = 0.0;

        for (Device device : devices) {
            numDistinctTypes++;
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types created: " + numDistinctTypes);
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}