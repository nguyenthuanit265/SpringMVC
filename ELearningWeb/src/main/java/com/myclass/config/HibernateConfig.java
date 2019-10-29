package com.myclass.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // Kích hoạt transaction tự động
@PropertySource("classpath:db.properties")
public class HibernateConfig {
	/*
	 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/ElearningWeb");
	 * dataSource.setUsername("root"); dataSource.setPassword("minhthuan"); return
	 * dataSource; }
	 * 
	 * @Bean public LocalSessionFactoryBean sessionFactory() {
	 * LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
	 * bean.setDataSource(dataSource());
	 * bean.setPackagesToScan("com.myclass.entity"); Properties properties = new
	 * Properties(); properties.put("hibernate.dialect",
	 * "org.hibernate.dialect.MySQLDialect"); properties.put("hibernate.show_sql",
	 * true); properties.put("hibernate.format_sql", true);
	 * bean.setHibernateProperties(properties);
	 * 
	 * return bean;
	 * 
	 * }
	 */

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/elearning");
//		dataSource.setUsername("root");
//		dataSource.setPassword("minhthuan");
//		return dataSource;
//	}
//
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setPackagesToScan("com.myclass.entity");
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		properties.put("hibernate.show_sql", true);
//		properties.put("hibernate.format_sql", true);
//		bean.setHibernateProperties(properties);
//		return bean;
//	}
	@Autowired
	private Environment environment;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("mysql.driver"));
		dataSource.setUrl(environment.getProperty("mysql.url"));
		dataSource.setUsername(environment.getProperty("mysql.username"));
		dataSource.setPassword(environment.getProperty("mysql.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan(environment.getProperty("hibernate.package_scan"));
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		bean.setHibernateProperties(properties);
		return bean;
	}

	// Cấu hình Transaction tự động

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory().getObject()); // getObject()=> trả về đúng SessionFactory
		return manager;

	}

}
