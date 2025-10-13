import java.util.*;

interface PaymentProcessor {
    void pay(double amount);
    default void refund(double amount) {
        System.out.println("Refund of " + amount + " processed (default)");
    }
}

class PayPal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class Stripe implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Stripe");
    }
    public void refund(double amount) {
        System.out.println("Stripe refund of " + amount + " completed");
    }
}

class payGate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double amt = s.nextDouble();
        PaymentProcessor p1 = new PayPal();
        PaymentProcessor p2 = new Stripe();
        p1.pay(amt);
        p1.refund(amt);
        p2.pay(amt);
        p2.refund(amt);
    }
}
