public class Exp4 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Method Overloading :");
        System.out.println("Adding 2 variables: " + calculator.add(5, 10));
        System.out.println("Adding after changing data type of variables: " + calculator.add(5.5, 10.5));
        System.out.println("Adding 3 variables: " + calculator.add(5, 10, 15));
    }
}

class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
}
