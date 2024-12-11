package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    //Constructors
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        //this.balance = 0;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Getters
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    //Methods
    public int deposit(int amountToDeposit) {

        if (amountToDeposit > 0) {
            this.balance += amountToDeposit;
        }

        return this.balance;
    }

    public int withdraw(int amountToWithdraw) {

        if (amountToWithdraw > 0) {
            this.balance -= amountToWithdraw;
        }

        return this.balance;
    }

}
