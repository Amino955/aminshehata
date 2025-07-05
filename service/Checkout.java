package service;

public class Checkout {
    public static void process(Cart cart, PaymentMethod method) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double subtotal = cart.calculateSubtotal();
        double shippingWeight = cart.getShippingWeight();
        double shippingFee = shippingWeight > 0 ? 30.0 : 0.0;
        double total = subtotal + shippingFee;

        if (!method.pay(total)) {
            System.out.println("Payment failed. Not enough balance.");
            return;
        }

        if (shippingWeight > 0) {
            System.out.println("** Shipment notice **");
            for (CartItem item : cart.getItems()) {
                if (item.product.requiresShipping()) {
                    System.out.println(item.quantity + "x " + item.product.getName() + "    " +
                            (item.product.getWeight() * item.quantity * 1000) + "g");
                }
            }
            System.out.printf("Total package weight %.1fkg%n%n", shippingWeight);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + "    " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal        " + subtotal);
        System.out.println("Shipping        " + shippingFee);
        System.out.println("Amount          " + total);
        System.out.println("Remaining balance: " + method.getBalance());
    }
}