package ATMInterface;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be more then zero.");
        } else {
            System.out.println("Insufficient balance.");
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    
    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    
    public void handleUserInput() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1: 
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (!bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Transaction failed.");
                    } else {
                        System.out.println("Transaction successful.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Transaction successful.");
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + bankAccount.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);

        ATM atm = new ATM(userAccount);

        atm.handleUserInput();
    }
}
