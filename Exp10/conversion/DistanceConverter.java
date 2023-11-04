package conversion;

public class DistanceConverter {
    public static double convertMilesToKilometers(double miles) {
        return miles * 1.60934;
    }

    public static double convertKilometersToMiles(double kilometers) {
        return kilometers / 1.60934;
    }
}