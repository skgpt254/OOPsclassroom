package Assignment2.Level1;

public class ProfitCalculator {
    public static void main(String[] args) {
        int costPrice = 129, sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;

        System.out.println(profitPercent);
    }
}

