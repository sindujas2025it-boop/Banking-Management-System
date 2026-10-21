import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void showAccount(int accountNumber) {
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: Rs. " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}