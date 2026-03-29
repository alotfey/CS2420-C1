package module_2.project_2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAccountGUI extends JFrame implements ActionListener {

    private CheckingAccount account;

    // Input fields
    private JTextField firstNameField = new JTextField(15);
    private JTextField lastNameField = new JTextField(15);
    private JTextField accountIDField = new JTextField(15);
    private JTextField initialBalanceField = new JTextField(15);
    private JTextField amountField = new JTextField(15);

    // Buttons
    private JButton openAccountButton = new JButton("Open Account");
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton exitButton = new JButton("Exit");

    // Labels
    private JLabel balanceLabel = new JLabel("Balance: $0.00");
    private JLabel messageLabel = new JLabel(" ");

    public BankAccountGUI() {
        setTitle("Bank Balance Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showSetupPanel();
    }

    // Build the setup screen where the user enters their account info
    private void showSetupPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Open Account"));

        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);

        panel.add(new JLabel("Account ID:"));
        panel.add(accountIDField);

        panel.add(new JLabel("Initial Balance ($):"));
        panel.add(initialBalanceField);

        panel.add(new JLabel(""));
        openAccountButton.addActionListener(this);
        panel.add(openAccountButton);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Build the main screen where the user deposits and withdraws
    private void showMainPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Account"));

        panel.add(new JLabel("Account Holder:"));
        panel.add(new JLabel(account.getFirstName() + " " + account.getLastName()));

        panel.add(new JLabel("Account ID:"));
        panel.add(new JLabel(String.valueOf(account.getAccountID())));

        panel.add(new JLabel("Current Balance:"));
        panel.add(balanceLabel);

        panel.add(new JLabel("Amount ($):"));
        panel.add(amountField);

        depositButton.addActionListener(this);
        panel.add(depositButton);

        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        panel.add(messageLabel);

        exitButton.addActionListener(this);
        panel.add(exitButton);

        // Update the balance label with the current balance
        balanceLabel.setText(String.format("$%.2f", account.getBalance()));

        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openAccountButton) {
            openAccount();
        } else if (e.getSource() == depositButton) {
            deposit();
        } else if (e.getSource() == withdrawButton) {
            withdraw();
        } else if (e.getSource() == exitButton) {
            exit();
        }
    }

    // Open a new checking account with the user's info
    private void openAccount() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String idText = accountIDField.getText();
        String balanceText = initialBalanceField.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || idText.isEmpty() || balanceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        int accountID = Integer.parseInt(idText);
        double initialBalance = Double.parseDouble(balanceText);

        account = new CheckingAccount(firstName, lastName, accountID, 2.5);
        account.deposit(initialBalance);

        showMainPanel();
    }

    // Deposit the entered amount into the account
    private void deposit() {
        double amount = Double.parseDouble(amountField.getText());
        account.deposit(amount);
        balanceLabel.setText(String.format("$%.2f", account.getBalance()));
        messageLabel.setText("Deposited $" + amount);
        amountField.setText("");
    }

    // Withdraw the entered amount from the account
    private void withdraw() {
        double amount = Double.parseDouble(amountField.getText());
        account.processWithdrawal(amount);
        balanceLabel.setText(String.format("$%.2f", account.getBalance()));
        messageLabel.setText("Withdrew $" + amount);
        amountField.setText("");
    }

    // Show the final balance and close the application
    private void exit() {
        JOptionPane.showMessageDialog(this,
                "Final Balance for " + account.getFirstName() + " " + account.getLastName()
                + ": $" + String.format("%.2f", account.getBalance()));
        System.exit(0);
    }
}
