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

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void RemoveAll(List<Student> students) {
		accountRepository.RemoveAll(students);
	}

	public List<Student> GetListStudent() {
		return accountRepository.getListStudent();
	}

	public void Insert(Student student) {
		accountRepository.add(student);

	}

	public void Delete(int id) {
		accountRepository.delete(id);

	}

	public void Update(int id) {
		accountRepository.edit(id);

	}

	public Student FindById(int id) {
		return accountRepository.FindById(id);
	}

}
