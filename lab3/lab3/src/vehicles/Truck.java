package vehicles;

import java.util.Scanner;

public class Truck extends Vehicle {
    private static final long serialVersionUID = 1L;

    private double loadCapacity; // in tons

    public Truck() {
    }

    public Truck(String brand, String model, int year, double loadCapacity) {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter load capacity (tons): ");
        setLoadCapacity(Double.parseDouble(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", loadCapacity=" + loadCapacity + "t";
    }
}