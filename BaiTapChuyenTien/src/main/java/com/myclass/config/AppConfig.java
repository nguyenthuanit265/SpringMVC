package com.myclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.myclass.entity.Account;

@Configuration
@ComponentScan("com.myclass")
public class AppConfig {

	/*
	 * <bean id="accountRepository"
	 * class="com.myclass.repository.AccountRepositoryImpl"></bean>
	 */

//	@Bean
//	public AccountRepository accountRepository() {
//		return new AccountRepositoryImpl();
//	}

	/*
	 * <bean id="accountService" class="com.myclass.service.AccountServiceImpl">
	 * <constructor-arg ref="accountRepository"></constructor-arg> </bean>
	 */
//	@Bean
//	public AccountService accountService() {
//		return new AccountServiceImpl(accountRepository());
//
//	}

	@Bean
	public Account account1() {
		return new Account(1, "A", 100);
	}

	@Bean
	public Account account2() {
		return new Account(2, "B", 200);
	}

}
