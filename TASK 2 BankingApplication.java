import java.util.Scanner;

public class BankingApplication {
    // Class variables
    private double balance;
    private double previousTransaction;
    private String customerName;

    // Constructor to initialize customer name
    public BankingApplication(String customerName) {
        this.customerName = customerName;
    }

    // Function to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Function to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                previousTransaction = -amount;
                System.out.println("Successfully withdrawn $" + amount);
            } else {
                System.out.println("Insufficient balance. Your current balance is $" + balance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Function to display the previous transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Last Transaction: Deposited $" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Last Transaction: Withdrawn $" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has occurred.");
        }
    }

    // Function to show the main menu
    public void showMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Welcome to your Banking Application");
        System.out.println("\n");

        do {
            System.out.println("*************************************************");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Exit");
            System.out.println("*************************************************");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 5: ");
                scanner.next();
            }
            option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Your current balance is $" + balance);
                    System.out.println("-----------------------------");
                    break;

                case 2:
                    System.out.println("-----------------------------");
                    System.out.print("Enter an amount to deposit: $");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Please enter a valid amount to deposit: $");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    System.out.println("-----------------------------");
                    break;

                case 3:
                    System.out.println("-----------------------------");
                    System.out.print("Enter an amount to withdraw: $");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Please enter a valid amount to withdraw: $");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    System.out.println("-----------------------------");
                    break;

                case 4:
                    System.out.println("-----------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------");
                    break;

                case 5:
                    System.out.println("*******************************");
                    System.out.println("Thank you for using our services. Goodbye!");
                    System.out.println("*******************************");
                    break;

                default:
                    System.out.println("Invalid Option! Please enter a number between 1 and 5.");
                    break;
            }

            System.out.println();

        } while (option != 5);

        scanner.close();
    }

    public static void main(String[] args) {
        BankingApplication bankApp = new BankingApplication("John Doe");
        bankApp.showMenu();
    }
}
