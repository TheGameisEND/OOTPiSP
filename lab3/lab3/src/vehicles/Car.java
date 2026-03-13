package vehicles;

import java.util.Scanner;

/**
 * Represents a car.
 */
public class Car extends Vehicle {
    private static final long serialVersionUID = 1L;

    private int doors;

    public Car() {
    }

    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.doors = doors;
    }

    public int getDoors() { return doors; }
    public void setDoors(int doors) { this.doors = doors; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter number of doors: ");
        setDoors(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", doors=" + doors;
    }
}