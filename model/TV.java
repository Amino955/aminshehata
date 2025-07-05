package model;

public class TV extends Product {
    public TV(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public boolean isExpired() {
        return false;
    }

    public boolean requiresShipping() {
        return true;
    }

    public double getWeight() {
        return 5.0;
    }
}