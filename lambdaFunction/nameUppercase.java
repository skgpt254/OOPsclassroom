import java.util.*;
import java.util.stream.*;

public class nameUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String> upper = names.stream()
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toList());
        upper.forEach(System.out::println);
    }
}
