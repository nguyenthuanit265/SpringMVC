package com.myclass.service;

import java.util.List;

import com.myclass.entity.Student;
import com.myclass.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Student> GetListStudent() {
		return accountRepository.getListStudent();
	}

	public void Insert(Student student) {
		accountRepository.add(student);

	}

	public void Delete(Student student) {
		accountRepository.delete(student);

	}

	public void Update(Student student) {
		accountRepository.edit(student);

	}

	public Student FindById(int id) {
		return accountRepository.FindById(id);
	}

}
