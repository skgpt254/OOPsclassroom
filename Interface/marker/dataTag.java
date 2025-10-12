import java.util.*;

interface SensitiveData {}

class Employee implements SensitiveData {
    String name;
    String password;
    Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class dataTag {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        String pwd = s.nextLine();
        Employee emp = new Employee(name, pwd);

        if (emp instanceof SensitiveData)
            System.out.println("Data is sensitive. Encryption applied.");
        else
            System.out.println("Data is normal.");
    }
}
