interface Payment {
    void pay();
}

class UPI implements Payment {
    public void pay() { System.out.println("Paid using UPI"); }
}

class CreditCard implements Payment {
    public void pay() { System.out.println("Paid using Credit Card"); }
}

class payment {
    public static void main(String[] args) {
        Payment p = new CreditCard();
        p.pay();
    }
}