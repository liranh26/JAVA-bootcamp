package banking_project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import accounts.Account;
import accounts.AccountProperties;

class AccountTest {
	
	ArrayList<Account> accounts;
	
	AccountTest(){
		accounts = new ArrayList<Account>();
		accounts.add(new Account(AccountProperties.GOLD, 10000));
		accounts.add(new Account(AccountProperties.SILVER, 1000));
		accounts.add(new Account(AccountProperties.BRONZE, 2000));
	}
	
	@Test
	void testAccoundId() {
		assertNotEquals(accounts.get(0).getACCOUNT_ID(), accounts.get(1).getACCOUNT_ID());
		assertNotEquals(accounts.get(1).getACCOUNT_ID(), accounts.get(2).getACCOUNT_ID());
	}
	
	@Test
	void testCctivity() {
//		accounts.get(0).set
	}
}
