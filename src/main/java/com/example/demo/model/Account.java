package com.example.demo.model;


import com.example.demo.exception.SavingAccountException;

public interface Account {

    public void withdraw(Float value) throws SavingAccountException;

    public void deposit(Float value) throws SavingAccountException;

    public Float getAmount();

}