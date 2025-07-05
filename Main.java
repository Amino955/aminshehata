import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 5, false, 0.2);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, false, 0.35);
        TV tv = new TV("Smart TV", 3000, 2);
        ScratchCard card = new ScratchCard("Vodafone Card", 50, 10);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 0); // Just testing
        cart.add(card, 1);

        PaymentMethod method = new FawryPay(1000);
        Checkout.process(cart, method);
    }
}