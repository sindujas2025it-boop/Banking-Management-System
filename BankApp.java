import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n===== SECURE BANK =====");
            System.out.println("1. Open Savings Account");
            System.out.println("2. Open Current Account");
            System.out.println("3. View Account Details");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter account number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    if (balance < 0 || (choice == 1 && balance < 1000)) {
                        System.out.println("Invalid initial balance.");
                    } else if (bank.findAccount(number) != null) {
                        System.out.println("Account number already exists.");
                    } else if (choice == 1) {
                        bank.addAccount(new SavingsAccount(number, name, balance));
                    } else {
                        bank.addAccount(new CurrentAccount(number, name, balance));
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    bank.showAccount(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    Account depositAccount = bank.findAccount(sc.nextInt());
                    System.out.print("Enter amount: ");
                    double depositAmount = sc.nextDouble();

                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    Account withdrawAccount = bank.findAccount(sc.nextInt());
                    System.out.print("Enter amount: ");
                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using SecureBank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}