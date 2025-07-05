package model;

public class Biscuits extends Product {
    private boolean expired;
    private double weight;

    public Biscuits(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity);
        this.expired = expired;
        this.weight = weight;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean requiresShipping() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}