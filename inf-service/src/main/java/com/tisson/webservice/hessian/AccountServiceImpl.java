package com.tisson.webservice.hessian;

import java.util.ArrayList;
import java.util.List;

// the implementation doing nothing at the moment
public class AccountServiceImpl implements AccountService {

	
	
    public void insertAccount(Account acc) {
        // do something...
    	System.out.println("insertAccount");
    }

    public List<Account> getAccounts(String name) {
    	List<Account>  list = new ArrayList<Account>();
    	Account acc = new Account();
    	acc.setName("shuangming");
		list.add(acc);
    	
		// do something...
		return list;
    }
}