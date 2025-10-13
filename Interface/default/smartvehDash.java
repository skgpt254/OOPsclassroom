import java.util.*;

interface Vehicle {
    void displaySpeed(int speed);
    default void displayBattery(int percent) {
        System.out.println("Battery: " + percent + "%");
    }
}

class PetrolCar implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Speed: " + speed + " km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed(int speed) {
        System.out.println("Speed: " + speed + " km/h");
    }
    public void displayBattery(int percent) {
        System.out.println("Battery level: " + percent + "%");
    }
}

class smartvehDash {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int speed = s.nextInt();
        int battery = s.nextInt();
        Vehicle v1 = new PetrolCar();
        Vehicle v2 = new ElectricCar();
        v1.displaySpeed(speed);
        v2.displaySpeed(speed);
        v2.displayBattery(battery);
    }
}
