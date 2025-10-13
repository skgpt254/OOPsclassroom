import java.util.*;

interface SecurityUtils {
    static boolean isStrongPassword(String pwd) {
        return pwd.length() >= 8 && pwd.matches(".*[A-Z].*") && pwd.matches(".*[0-9].*") && pwd.matches(".*[!@#$%^&*].*");
    }
}

class passValid {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String pwd = s.nextLine();
        if (SecurityUtils.isStrongPassword(pwd))
            System.out.println("Strong Password");
        else
            System.out.println("Weak Password");
    }
}
