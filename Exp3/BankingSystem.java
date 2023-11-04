import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank {
    private Map<Integer, Double> accounts;
    private int accountNumberCounter;

    public Bank() {
        accounts = new HashMap<>();
        accountNumberCounter = 1000; // Starting account number
    }

    public int createAccount(double initialBalance) {
        accountNumberCounter++;
        accounts.put(accountNumberCounter, initialBalance);
        return accountNumberCounter;
    }

    public double getBalance(int accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    public void deposit(int accountNumber, double amount) {
        double currentBalance = accounts.getOrDefault(accountNumber, 0.0);
        accounts.put(accountNumber, currentBalance + amount);
        System.out.println("Deposited " + amount + " into account " + accountNumber);
    }

    public void withdraw(int accountNumber, double amount) {
        double currentBalance = accounts.getOrDefault(accountNumber, 0.0);
        if (currentBalance >= amount) {
            accounts.put(accountNumber, currentBalance - amount);
            System.out.println("Withdrawn " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance for withdrawal from account " + accountNumber);
        }
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to the Banking System");
            System.out.println("1. Create an Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    int accountNumber = bank.createAccount(initialBalance);
                    System.out.println("Account created with number: " + accountNumber);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accNumCheck = scanner.nextInt();
                    double balance = bank.getBalance(accNumCheck);
                    System.out.println("Balance for account " + accNumCheck + " is: " + balance);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accNumDeposit = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accNumDeposit, depositAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int accNumWithdraw = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(accNumWithdraw, withdrawAmount);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
