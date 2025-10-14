import java.util.*;
import java.util.stream.*;

class Invoice {
    String transactionID;
    Invoice(String id) { transactionID = id; }
    public String toString() { return "Invoice for " + transactionID; }
}

public class invoiceObj {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("T1001", "T1002", "T1003");
        List<Invoice> invoices = ids.stream()
                                    .map(Invoice::new)
                                    .collect(Collectors.toList());
        invoices.forEach(System.out::println);
    }
}
