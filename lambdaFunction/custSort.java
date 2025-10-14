import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String n, double p, double r, double d) {
        name = n; price = p; rating = r; discount = d;
    }

    public String toString() {
        return name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount;
    }
}

public class custSort {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Phone", 700, 4.5, 10),
            new Product("Laptop", 1200, 4.7, 15),
            new Product("Headphones", 100, 4.3, 25)
        );

        Scanner sc = new Scanner(System.in);
        String criterion = sc.next();

        if (criterion.equals("price"))
            products.sort((a, b) -> Double.compare(a.price, b.price));
        else if (criterion.equals("rating"))
            products.sort((a, b) -> Double.compare(b.rating, a.rating));
        else if (criterion.equals("discount"))
            products.sort((a, b) -> Double.compare(b.discount, a.discount));

        products.forEach(System.out::println);
    }
}
