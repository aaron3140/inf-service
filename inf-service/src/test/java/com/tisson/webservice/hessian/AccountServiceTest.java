package com.tisson.webservice.hessian;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends AbstractServiceTest {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void testGetAccounts() {
		List<Account> accounts = accountService.getAccounts("");
		for(Account a:accounts)
		{
			System.out.println(a);
		}
	}

}
