package com.example.demo.main;


import com.example.demo.exception.SavingAccountException;
import com.example.demo.model.Customer;
import com.example.demo.model.SavingAccount;

/* ASSUMPTIONS
*  - A costumer could have only an account
* */

/* NOTES
 *
 * */

public class Main {
    public static void main(String[] args) throws SavingAccountException {

        Customer customer1 = new Customer("00000001",new SavingAccount());
        System.out.println("#Initial Amount customer 1");
        System.out.println(customer1);

        customer1.getAccount().deposit(100F);

        System.out.println("#Amount after deposit for customer 1");
        System.out.println(customer1);

        Customer customer2 = new Customer("00000001",new SavingAccount(100F));

        System.out.println("#Initial Amount customer 2");
        System.out.println(customer2);

        customer1.getAccount().withdraw(100F);
        System.out.println("#Amount after withdraw for customer 2");
        System.out.println(customer1);

    }
}