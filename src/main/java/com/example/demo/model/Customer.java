package com.example.demo.model;

/*NOTE: It is possible to improve this using @Getter and Setter Lombok
* */
public class Customer {

    private String id;
    private Account account;

    public Customer(String id, Account account) {
        this.id = id;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", account=" + account +
                '}';
    }
}
