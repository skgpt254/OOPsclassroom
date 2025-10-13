interface Device {
    void turnOn();
    void turnOff();
}

class Light implements Device {
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }
}

class TV implements Device {
    public void turnOn() { System.out.println("TV ON"); }
    public void turnOff() { System.out.println("TV OFF"); }
}

class SmartDevice {
    public static void main(String[] args) {
        Device d1 = new Light();
        Device d2 = new TV();
        d1.turnOn();
        d2.turnOn();
    }
}
