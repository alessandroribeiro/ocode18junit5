package net.integritas.oraclecode18.junit5.ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BankAccountTest {

	@Test()
	void testCredit() {
		BankAccount acct = new BankAccount(100, 0);
		acct.credit(50);
		assertEquals(150, acct.getBalance());
	}

	@Test
	void testDebt_Scenario1() {
		BankAccount acct = new BankAccount(100, 0);
		boolean success = acct.debt(50);
		assertTrue(success);
		assertEquals(50, acct.getBalance());
	}

	@Test
	void testDebt_Scenario2() {
		BankAccount acct = new BankAccount(100, 0);
		boolean success = acct.debt(100);
		assertTrue(success);
		assertEquals(0, acct.getBalance());
	}
	
	@Test
	void testDebt_Scenario3() {		
		BankAccount acct = new BankAccount(100, 0);
		boolean success = acct.debt(110);
		assertFalse(success);
		assertEquals(100, acct.getBalance());
	}
	
	@Test
	void testDebt_Scenario4() {
		BankAccount acct = new BankAccount(100, 20);
		boolean success = acct.debt(110);
		assertTrue(success);
		assertEquals(-10, acct.getBalance());
	}

	@Test
	void testDebt_Scenario5() {
		BankAccount acct = new BankAccount(100, 20);
		boolean success = acct.debt(140);
		assertFalse(success);
		assertEquals(100, acct.getBalance());
	}

}
