public class Exp5 {
    public static void main(String[] args) {
        new MyClass("Hello").display();
    }
}

class MyClass {
    private String message;

    public MyClass() {
        this("Default");
    }

    public MyClass(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println("Message: " + message);
    }
}
