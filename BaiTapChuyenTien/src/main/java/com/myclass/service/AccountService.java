package com.myclass.service;

import com.myclass.entity.Account;

public interface AccountService {
	public void TransferMoney(int fromId, int toId, long mount);

	public void Insert(Account account);

	public Account FindById(int id);
}
