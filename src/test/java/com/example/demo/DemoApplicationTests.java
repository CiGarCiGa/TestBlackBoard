package com.example.demo;

import com.example.demo.exception.SavingAccountException;
import com.example.demo.model.Customer;
import com.example.demo.model.SavingAccount;
import org.junit.jupiter.api.*;
import sun.rmi.rmic.Main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class mainTests {

	private List<Customer> customers;

	@Test
	void contextLoads() {
	}
	@Test
	void main() {
		Main.main(new String[] {});
	}


	@BeforeEach
	void init(){
		customers=new ArrayList<>();
		customers.add(new Customer("1",new SavingAccount()));
		customers.add(new Customer("2",new SavingAccount(100F)));
		customers.add(new Customer("3",new SavingAccount(50F)));
	}

	@Test
	public void allowCustomerDeposit() throws SavingAccountException {
		Float amount = 100F;
		assertNotNull(customers.get(0).getAccount().getAmount());
		customers.get(0).getAccount().deposit(amount);
		assertNotNull(customers.get(0).getAccount().getAmount());
		assertEquals(customers.get(0).getAccount().getAmount(),amount);
	}

	@Test
	public void allowCustomerWithdraw() throws SavingAccountException {
		Float amount = 100F;
		assertNotNull(customers.get(0).getAccount().getAmount());
		customers.get(1).getAccount().withdraw(amount);
		assertNotNull(customers.get(0).getAccount().getAmount());
		assertEquals(customers.get(1).getAccount().getAmount(),0);
	}

	@Test
	public void throwExceptionIfWithdrawValueIsHigherThanAmount() throws SavingAccountException {
		Float amount = 100F;
		assertNotNull(customers.get(0).getAccount().getAmount());
		assertThrows(SavingAccountException.class, () -> customers.get(2).getAccount().withdraw(amount));
	}

	@Test
	public void throwExceptionIfAmountIsNegativeForCustomerDeposit() throws SavingAccountException {
		Float amount = -100F;
		assertNotNull(customers.get(0).getAccount().getAmount());
		assertThrows(SavingAccountException.class, () -> customers.get(0).getAccount().deposit(amount));
	}

	@Test
	public void throwExceptionIfAmountIsNegativeForCustomerWithdraw() throws SavingAccountException {
		Float amount = -100F;
		assertNotNull(customers.get(0).getAccount().getAmount());
		assertThrows(SavingAccountException.class, () -> customers.get(0).getAccount().withdraw(amount));
	}

	@AfterEach
	void teardown(){
		customers.clear();
	}

}
