package Assignment2.Level1;

public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double pi = Math.PI;

        double volumeKm3 = (4.0 / 3) * pi * Math.pow(radiusKm, 3);
        double volumeMiles3 = volumeKm3 / Math.pow(1.6, 3); 
        System.out.println(volumeMiles3);
    }
}

