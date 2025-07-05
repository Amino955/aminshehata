package service;

import model.Product;
import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("Error: Product " + product.getName() + " is expired.");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Error: Not enough quantity for " + product.getName());
            return;
        }

        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double getShippingWeight() {
        double weight = 0;
        for (CartItem item : items) {
            if (item.product.requiresShipping()) {
                weight += item.product.getWeight() * item.quantity;
            }
        }
        return weight;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}