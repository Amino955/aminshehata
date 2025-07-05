package service;

public class FawryPay implements PaymentMethod {
    private double balance;

    public FawryPay(double balance) {
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}