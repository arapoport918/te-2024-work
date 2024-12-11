package com.techelevator;

public class CheckingAccount extends BankAccount {

    public static final int MINIMUM_BALANCE = -100;
    public static final int MAXIMUM_WITHDRAW = 100;
    public static final int OVERDRAFT_FEE = 10;

    //Constructors
    public CheckingAccount(String accountHolder, String accountNumber) {
        super(accountHolder, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Method Override
    @Override
    public int withdraw (int amountToWithdraw) {

        int originalBalance = this.getBalance();
        int wouldBeBalance = originalBalance - amountToWithdraw; //not actually withdrawing


        if (originalBalance - amountToWithdraw > MINIMUM_BALANCE) {
            super.withdraw(amountToWithdraw); //withdraw the amount since it's all good
            if (wouldBeBalance < 0) {
                super.withdraw(OVERDRAFT_FEE);
            }
            return super.getBalance();
        }

        return originalBalance;
    }
}
