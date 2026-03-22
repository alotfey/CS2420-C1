package module1.project1;

public class Main {
    public static void main(String[] args) {

        // ── BankAccount Tests ──────────────────────────────────────────────
        System.out.println("===== BankAccount Test =====");
        BankAccount bankAccount = new BankAccount("Ahmed", "Lotfey", 1001);

        // Test deposit
        System.out.println("\n-- deposit($500.00) --");
        bankAccount.deposit(500.00);
        bankAccount.accountSummary();

        // Test withdrawal
        System.out.println("\n-- withdrawal($200.00) --");
        bankAccount.withdrawal(200.00);
        bankAccount.accountSummary();

        // Test setters
        System.out.println("\n-- setFirstName / setLastName / setAccountID --");
        bankAccount.setFirstName("Ahmed");
        bankAccount.setLastName("Lotfey");
        bankAccount.setAccountID(9999);
        System.out.println("First Name: " + bankAccount.getFirstName());
        System.out.println("Last Name:  " + bankAccount.getLastName());
        System.out.println("Account ID: " + bankAccount.getAccountID());
        System.out.println("Balance:    $" + bankAccount.getBalance());

        // ── CheckingAccount Tests ──────────────────────────────────────────
        System.out.println("\n===== CheckingAccount Test =====");
        CheckingAccount checkingAccount = new CheckingAccount("Ahmed", "Lotfey", 2001, 2.5);

        // Test displayAccount (shows all fields + interest rate)
        System.out.println("\n-- displayAccount() on new account --");
        checkingAccount.displayAccount();

        // Test deposit
        System.out.println("\n-- deposit($300.00) --");
        checkingAccount.deposit(300.00);
        checkingAccount.displayAccount();

        // Test processWithdrawal — no overdraft
        System.out.println("\n-- processWithdrawal($100.00) — no overdraft --");
        checkingAccount.processWithdrawal(100.00);
        checkingAccount.displayAccount();

        // Test processWithdrawal — triggers overdraft
        System.out.println("\n-- processWithdrawal($500.00) — overdraft triggered --");
        checkingAccount.processWithdrawal(500.00);
        checkingAccount.displayAccount();

        // Test setters
        System.out.println("\n-- setInterestRate(3.75) --");
        checkingAccount.setInterestRate(3.75);
        System.out.println("Interest Rate: " + checkingAccount.getInterestRate() + "%");
    }
}