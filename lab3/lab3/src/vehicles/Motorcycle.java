package vehicles;

import java.util.Scanner;

public class Motorcycle extends Vehicle {
    private static final long serialVersionUID = 1L;

    private boolean hasSidecar;

    public Motorcycle() {
    }

    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() { return hasSidecar; }
    public void setHasSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }

    @Override
    public void editProperties(Scanner scanner) {
        System.out.print("Enter brand: ");
        setBrand(scanner.nextLine());
        System.out.print("Enter model: ");
        setModel(scanner.nextLine());
        System.out.print("Enter year: ");
        setYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Has sidecar? (true/false): ");
        setHasSidecar(Boolean.parseBoolean(scanner.nextLine()));
    }

    @Override
    public String toString() {
        return super.toString() + ", hasSidecar=" + hasSidecar;
    }
}