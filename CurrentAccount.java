public class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (balance - amount >= -5000) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Current balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal failed! Overdraft limit is Rs. 5000.");
        }
    }
}