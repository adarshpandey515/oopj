import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class SalaryCalculator {
    static Map<Integer, Employee> employees = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Select an option:");
            System.out.println("1. Register as a new user");
            System.out.println("2. Continue as an existing user");
            System.out.println("3. Exit");

            int choice = readIntegerInput(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    registerNewUser(sc);
                    break;
                case 2:
                    continueAsExistingUser(sc);
                    break;
                case 3:
                    continueProgram = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }
        sc.close();
    }

    public static int readIntegerInput(Scanner sc, String message) {
        int input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); 
            }
        }
        return input;
    }

    public static void registerNewUser(Scanner sc) {
        System.out.println("Enter your name:");
        sc.nextLine(); 
        String name = sc.nextLine();

       //System.out.println("Enter your ID:");
        int emp_id = readIntegerInput(sc, "Enter your ID: ");

        if (employees.containsKey(emp_id)) {
            System.out.println("Employee ID already exists. Please continue as an existing user.");
        } else {
            double bs = readDoubleInput(sc, "Enter your basic salary: ");

            employees.put(emp_id, new Employee(name, emp_id, bs));
            System.out.println("User registered successfully!");
        }
    }

    public static double readDoubleInput(Scanner sc, String message) {
        double input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); 
            }
        }
        return input;
    }

    public static void continueAsExistingUser(Scanner sc) {
        //System.out.println("Enter your ID:");
        int emp_id = readIntegerInput(sc, "Enter your ID: ");

        if (employees.containsKey(emp_id)) {
            Employee existingEmployee = employees.get(emp_id);
            System.out.println("Welcome back, " + existingEmployee.getName());
            calculateSalary(existingEmployee);
        } else {
            System.out.println("Employee ID not found. Please register as a new user.");
        }
    }

    public static void calculateSalary(Employee employee) {
        double DA = 0.70 * employee.getBasicSalary();
        double HRA = 0.30 * employee.getBasicSalary();
        double CCA = 240;
        double PF = 0.10 * employee.getBasicSalary();
        double PT = 100;
        double gs = employee.getBasicSalary() + HRA + DA + CCA;
        double ns = employee.getBasicSalary() - PT - PF;

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmpId());
        System.out.println("Basic Salary: INR" + df.format(employee.getBasicSalary()));
        System.out.println("Gross Salary: INR" + df.format(gs));
        System.out.println("Net Salary: INR" + df.format(ns));
    }
}

class Employee {
    private String name;
    private int emp_id;
    private double basicSalary;

    public Employee(String name, int emp_id, double basicSalary) {
        this.name = name;
        this.emp_id = emp_id;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return emp_id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}
