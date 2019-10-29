package com.myclass.service;

import java.util.List;

import com.myclass.entity.Student;
import com.myclass.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository=accountRepository;
	}

	public List<Student> getListStudent() {
		return accountRepository.getListStudent();
	}

	


	public void edit(Student student) {
		accountRepository.edit(student);
		
	}

	public void edit(int id) {
		
		
	}

	public void delete(Student student) {
		accountRepository.delete(student);
		
	}

	public void delete(int id) {
		accountRepository.delete(id);
		
	}

	public Student FindById(int id) {
		return accountRepository.FindById(id);
	}

	public void add(Student student) {
		// TODO Auto-generated method stub
		
	}

	

}
