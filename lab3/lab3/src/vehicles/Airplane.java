package vehicles;

import java.util.Scanner;

public class Airplane extends Vehicle {
    private static final long serialVersionUID = 1L;

    private int engines;

    public Airplane() {
    }

    public Airplane(String brand, String model, int year, int engines) {
        super(brand, model, year);
        this.engines = engines;
    }

    public int getEngines() { return engines; }
    public void setEngines(int engines) { this.engines = engines; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter number of engines: ");
        setEngines(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", engines=" + engines;
    }
}