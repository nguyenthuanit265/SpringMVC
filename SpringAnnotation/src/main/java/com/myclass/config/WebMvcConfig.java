package com.myclass.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*Cấu hình Spring*/

@Configuration
@EnableWebMvc // tương ứng với <context:annotation-config />
@ComponentScan(basePackages = "com.myclass") // tương ứng <context:component-scan base-package="com.myclass" />
public class WebMvcConfig implements WebMvcConfigurer {

	/*
	 * <bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name="prefix" value="/WEB-INF/views/"></property> <property
	 * name="suffix" value=".jsp" /> <!-- Có thể khai báo đuôi html hoặc .jsp -->
	 * 
	 * </bean>/SpringAnnotation/src/main/webapp
	 */
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
