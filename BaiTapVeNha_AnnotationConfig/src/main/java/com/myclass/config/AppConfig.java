package com.myclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myclass.repository.AccountRepository;
import com.myclass.repository.AccountRepositoryImpl;
import com.myclass.service.AccountService;
import com.myclass.service.AccountServiceImpl;

@Configuration
@ComponentScan("com.myclass")
public class AppConfig {
//	@Bean
//	public AccountRepository accountRepository() {
//		return new AccountRepositoryImpl();
//	}
//	
//	@Bean
//	public AccountService accountService() {
//		return new AccountServiceImpl(accountRepository());
//	}
	

}
