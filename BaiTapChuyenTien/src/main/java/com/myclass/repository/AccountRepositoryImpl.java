package com.myclass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	private List<Account> listAccount;

	public AccountRepositoryImpl() {
		listAccount = new ArrayList<Account>();
	}

	public void Add(Account account) {
		listAccount.add(account);

	}

	public void Update(Account account) {
		Account model = FindById(account.getId());
		model.setName(account.getName());
		model.setMoney(account.getMoney());

	}

	public Account FindById(int id) {
		for (Account acc : listAccount) {
			if (acc.getId() == id) {

				return acc;
			}
		}
		return null;
	}

}
