package vehicles;

import java.util.Scanner;

public class Boat extends Vehicle {
    private static final long serialVersionUID = 1L;

    private double length; // meters

    public Boat() {
    }

    public Boat(String brand, String model, int year, double length) {
        super(brand, model, year);
        this.length = length;
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter length (meters): ");
        setLength(Double.parseDouble(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", length=" + length + "m";
    }
}
