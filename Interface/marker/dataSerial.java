import java.io.*;
import java.util.*;

class UserData implements Serializable {
    String name;
    int age;
    UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class dataSerial {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();
            int age = s.nextInt();
            UserData user = new UserData(name, age);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("backup.dat"));
            out.writeObject(user);
            out.close();
            System.out.println("Data serialized for backup.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
