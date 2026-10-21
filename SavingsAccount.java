public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal failed! Minimum balance of Rs. 1000 must be maintained.");
        }
    }
}