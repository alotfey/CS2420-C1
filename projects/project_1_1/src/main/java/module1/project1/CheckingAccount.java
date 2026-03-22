package module1.project1;

public class CheckingAccount extends BankAccount {
    // Instance variable
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.00;

    // Constructor extends BankAccount constructor and initializes interest rate
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Getters for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setters for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Overrides withdrawal to allow overdraft and charge a $30 fee
    public void processWithdrawal(double amount) {
        double newBalance = getBalance() - amount;
        if (newBalance < 0) {
            newBalance -= OVERDRAFT_FEE;
            withdrawal(amount + OVERDRAFT_FEE);
            System.out.printf("Overdraft fee applied. New balance: $%.2f (includes $30.00 overdraft fee)%n",
                    newBalance);
        } else {
            withdrawal(amount);
        }
    }

    // Displays all superclass attributes plus interest rate
    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate:  %.2f%%%n", interestRate);
    }
}
