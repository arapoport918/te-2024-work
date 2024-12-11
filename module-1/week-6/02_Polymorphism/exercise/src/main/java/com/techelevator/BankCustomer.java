package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();
    private static final int VIP_STATUS = 25000;

    //Getters + Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Methods
    public Accountable[] getAccounts(){
        Accountable[] accts = new Accountable[this.accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            accts[i] = accounts.get(i);
        }

        return accts;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip(){
        int totalBalance = 0;

        //search through list of Accounts
        for (int i = 0; i < accounts.size(); i++) {
            Accountable temp = this.accounts.get(i);
            totalBalance += temp.getBalance();
        }

        if (totalBalance >= VIP_STATUS) {
            return true;
        }

        return false;
    }
}
