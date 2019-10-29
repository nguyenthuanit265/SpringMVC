package com.myclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Student;
import com.myclass.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	
	
	@Autowired
	private AccountRepository accountRepository;
	
//	public AccountServiceImpl(AccountRepository accountRepository) {
//		this.accountRepository=accountRepository;
//	}

	public List<Student> getListStudent() {
		return accountRepository.getListStudent();
	}

	
	public void add(Student student) {
		accountRepository.add(student);
		
	}

	public void edit(Student student) {
		accountRepository.edit(student);
		
	}

	public void edit(int id) {
		accountRepository.edit(id);
		
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

	

}
