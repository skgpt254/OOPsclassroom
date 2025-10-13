import java.util.*;
import java.util.function.Function;

class lencheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Function<String, Integer> length = str -> str.length();
        String msg = s.nextLine();
        System.out.println("Message length: " + length.apply(msg));
    }
}
