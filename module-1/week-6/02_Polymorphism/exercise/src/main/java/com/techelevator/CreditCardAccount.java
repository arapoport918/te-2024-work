package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountHolderName;
    private String cardNumber;
    private int debt = 0;

    //Constructors
    public CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
    }

    //Getters
    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getDebt() {
        return this.debt;
    }

    @Override
    public int getBalance(){
        return -this.getDebt();
    }

    //Methods
    public int pay(int amountToPay) {

        if (amountToPay > 0) {
            this.debt -= amountToPay;
            return this.debt;
        }
        return this.debt;
    }

    public int charge(int amountToCharge) {

        if (amountToCharge > 0) {
            this.debt += amountToCharge;
            return this.debt;
        }
        return this.debt;
    }

}
