package vehicles;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Abstract base class for all vehicles.
 * Implements Serializable to support binary serialization.
 */
public abstract class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brand;
    private String model;
    private int year;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters and setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    /**
     * Allows editing of vehicle properties through user input.
     * @param scanner Scanner to read user input.
     */
    public abstract void editProperties(Scanner scanner);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}