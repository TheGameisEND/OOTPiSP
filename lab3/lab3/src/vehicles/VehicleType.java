package vehicles;

import java.util.Scanner;

/**
 * Enum representing types of vehicles with a factory method to create instances.
 * Adding a new vehicle type only requires adding a new constant and implementing create().
 */
public enum VehicleType {
    CAR {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Car:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Doors: ");
            int doors = Integer.parseInt(scanner.nextLine());
            return new Car(brand, model, year, doors);
        }
    },
    TRUCK {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Truck:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Load capacity (tons): ");
            double load = Double.parseDouble(scanner.nextLine());
            return new Truck(brand, model, year, load);
        }
    },
    MOTORCYCLE {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Motorcycle:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Has sidecar? (true/false): ");
            boolean sidecar = Boolean.parseBoolean(scanner.nextLine());
            return new Motorcycle(brand, model, year, sidecar);
        }
    },
    BICYCLE {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Bicycle:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of gears: ");
            int gears = Integer.parseInt(scanner.nextLine());
            return new Bicycle(brand, model, year, gears);
        }
    },
    BOAT {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Boat:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Length (meters): ");
            double length = Double.parseDouble(scanner.nextLine());
            return new Boat(brand, model, year, length);
        }
    },
    AIRPLANE {
        @Override
        public Vehicle create(Scanner scanner) {
            System.out.println("Enter details for Airplane:");
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of engines: ");
            int engines = Integer.parseInt(scanner.nextLine());
            return new Airplane(brand, model, year, engines);
        }
    };

    /**
     * Creates a new vehicle of this type, prompting the user for details.
     * @param scanner Scanner to read user input.
     * @return A new Vehicle instance.
     */
    public abstract Vehicle create(Scanner scanner);
}