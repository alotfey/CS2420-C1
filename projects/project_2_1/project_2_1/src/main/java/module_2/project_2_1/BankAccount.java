/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_2.project_2_1;

/**
 *
 * @author lotfey
 */

public class BankAccount {
    // Instance variables
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0;
    }

    // Method for depositing money
    public void deposit(double amount) {
        balance += amount;
    }

    // Method for withdrawing money
    public void withdrawal(double amount) {
        balance -= amount;
    }

    // Getters and Setters for firstname
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getters and Setters for lastname
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getters and Setters for accountID
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters and Setters for balance
    public double getBalance() {
        return balance;
    }

    // Method to print account summary
    public void accountSummary() {
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Account ID:     " + accountID);
        System.out.printf("Balance:        $%.2f%n", balance);
    }
}
