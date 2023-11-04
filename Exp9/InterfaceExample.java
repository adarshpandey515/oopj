interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double r;
    public Circle(double r) { this.r = r; }
    public double calculateArea() { return Math.PI * r * r; }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Area of the circle: " + circle.calculateArea());
    }
}
