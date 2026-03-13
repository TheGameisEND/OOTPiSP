package vehicles;

import java.util.Scanner;

public class Bicycle extends Vehicle {
    private static final long serialVersionUID = 1L;

    private int gears;

    public Bicycle() {
    }

    public Bicycle(String brand, String model, int year, int gears) {
        super(brand, model, year);
        this.gears = gears;
    }

    public int getGears() { return gears; }
    public void setGears(int gears) { this.gears = gears; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter number of gears: ");
        setGears(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", gears=" + gears;
    }
}
