package com.techelevator;

public class SavingsAccount extends BankAccount {

    public static final int MINIMUM_BALANCE = 150;
    public static final int OVERDRAFT_FEE = 2;

    //Constructors
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Method Override
    @Override
    public int withdraw(int amountToWithdraw) {

        int originalBalance = this.getBalance();
        int wouldBeBalance = originalBalance - amountToWithdraw;

        if (amountToWithdraw < 0) {
            return originalBalance;
        }

        if (wouldBeBalance < 0) {
            return originalBalance;
        }

        if (wouldBeBalance - OVERDRAFT_FEE < 0) {
            return originalBalance;
        }

        super.withdraw(amountToWithdraw);

        if (wouldBeBalance < 150) {
            wouldBeBalance = super.withdraw(OVERDRAFT_FEE);
            return wouldBeBalance;
        }

        return getBalance();
    }
}
