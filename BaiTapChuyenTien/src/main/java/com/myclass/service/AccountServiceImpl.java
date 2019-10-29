package com.myclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Account;
import com.myclass.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

//	public AccountServiceImpl(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//	}

	public void TransferMoney(int fromId, int toId, long mount) {
		Account source = accountRepository.FindById(fromId);
		Account target = accountRepository.FindById(toId);

		source.setMoney(source.getMoney() - mount);
		target.setMoney(target.getMoney() + mount);

	}

	public Account FindById(int id) {
		return accountRepository.FindById(id);
	}

	public void Insert(Account account) {
		accountRepository.Add(account);
	}

}
