import java.util.Vector;
import java.util.Scanner;

public class Exp6 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings (n): ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a string: ");
            vector.add(scanner.next());
        }

        System.out.println("Strings added to the vector: " + vector);
    }
}
