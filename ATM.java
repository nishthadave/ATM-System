import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);  // Initial balance of $500
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}

