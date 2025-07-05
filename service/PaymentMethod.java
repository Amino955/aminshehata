package service;

public interface PaymentMethod {
    boolean pay(double amount);
    double getBalance();
}