package com.example.demo.model;

import com.example.demo.exception.SavingAccountException;

public class SavingAccount implements Account{

    private Float total;

    public SavingAccount() {
        this.total = 0F;
    }

    public SavingAccount(Float total) {
        this.total = total;
    }

    public Float getTotal() {
        return total;
    }

    public void deposit(Float amount) throws SavingAccountException {
        if(amount <= 0)
            throw new SavingAccountException("The amount should be positive to deposit");
        this.total = this.total + amount;
    }

    @Override
    public Float getAmount() {
        return getTotal();
    }

    public void withdraw(Float amount) throws SavingAccountException {
        if(amount <= 0)
            throw new SavingAccountException("The amount should be positive to deposit");
        if(this.total-amount<0)
            throw new SavingAccountException("It is not possible to withdraw the amount");

        this.total = this.total - amount;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "total=" + total +
                '}';
    }
}
