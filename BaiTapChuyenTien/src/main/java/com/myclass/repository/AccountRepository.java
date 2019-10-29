package com.myclass.repository;

import com.myclass.entity.Account;

public interface AccountRepository {

	public void Add(Account account);

	public void Update(Account account);

	public Account FindById(int id);

}
