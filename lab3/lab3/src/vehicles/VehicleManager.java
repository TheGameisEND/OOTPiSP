package vehicles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based application to manage a list of vehicles.
 * Supports adding, editing, deleting, saving, and loading vehicles.
 */
public class VehicleManager {
    private List<Vehicle> vehicles;
    private Scanner scanner;
    private static final String FILE_NAME = "vehicles.dat";

    public VehicleManager() {
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addVehicle();
                    break;
                case 3:
                    editVehicle();
                    break;
                case 4:
                    deleteVehicle();
                    break;
                case 5:
                    saveToFile(FILE_NAME);
                    break;
                case 6:
                    loadFromFile(FILE_NAME);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\n--- Vehicle Manager ---");
        System.out.println("1. Show list of vehicles");
        System.out.println("2. Add a vehicle");
        System.out.println("3. Edit a vehicle");
        System.out.println("4. Delete a vehicle");
        System.out.println("5. Save to file");
        System.out.println("6. Load from file");
        System.out.println("0. Exit");
    }

    private void showList() {
        if (vehicles.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("\nList of vehicles:");
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println((i + 1) + ". " + vehicles.get(i));
            }
        }
    }

    private void addVehicle() {
        System.out.println("\nSelect vehicle type:");
        VehicleType[] types = VehicleType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].name());
        }
        int typeChoice = readInt("Enter type number: ");
        if (typeChoice < 1 || typeChoice > types.length) {
            System.out.println("Invalid type.");
            return;
        }
        VehicleType selectedType = types[typeChoice - 1];
        try {
            Vehicle newVehicle = selectedType.create(scanner);
            vehicles.add(newVehicle);
            System.out.println("Vehicle added.");
        } catch (Exception e) {
            System.out.println("Error creating vehicle: " + e.getMessage());
        }
    }

    private void editVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to edit.");
            return;
        }
        showList();
        int index = readInt("Enter number of vehicle to edit: ") - 1;
        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Vehicle v = vehicles.get(index);
        System.out.println("Editing: " + v);
        v.editProperties(scanner);
        System.out.println("Vehicle updated.");
    }

    private void deleteVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to delete.");
            return;
        }
        showList();
        int index = readInt("Enter number of vehicle to delete: ") - 1;
        if (index < 0 || index >= vehicles.size()) {
            System.out.println("Invalid index.");
            return;
        }
        vehicles.remove(index);
        System.out.println("Vehicle deleted.");
    }

    private void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(vehicles);
            System.out.println("List saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            vehicles = (List<Vehicle>) ois.readObject();
            System.out.println("List loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    private int readInt(String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter an integer.");
            }
        }
        return value;
    }

    public static void main(String[] args) {
        new VehicleManager().run();
    }
}