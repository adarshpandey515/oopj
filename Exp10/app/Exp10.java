package app;

import conversion.DistanceConverter;

public class Exp10 {
    public static void main(String[] args) {
        double miles = 10;
        double kilometers = DistanceConverter.convertMilesToKilometers(miles);
        System.out.println(miles + " miles is equivalent to " + kilometers + " kilometers");

        double kilometers2 = 16.09344;
        double miles2 = DistanceConverter.convertKilometersToMiles(kilometers2);
        System.out.println(kilometers2 + " kilometers is equivalent to " + miles2 + " miles");
    }
}