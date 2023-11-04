public class Exp2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Command Line Arguments:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No command line arguments provided.");
        }
    }
}
