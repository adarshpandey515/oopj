class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Exp11 {
    public static void main(String[] args) {
        try {
            int age = 15;

            if (age < 18) {
                throw new CustomException("Age must be 18 or older to access this service.");
            }

            System.out.println("Access granted. Welcome!");
        } catch (CustomException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
}
