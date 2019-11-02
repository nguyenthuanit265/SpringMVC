package com.myclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.myclass")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode( "HTML5" );
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
	
	//1
	@Bean
    public LayoutDialect layoutDialect() {
    	return new LayoutDialect();
    }
 
	//2
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver( templateResolver() );
        templateEngine.addDialect(layoutDialect());
        return templateEngine;
    }
 
    //3
    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine( templateEngine() );
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    } 
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    	resolver.setMaxUploadSize(10000000); // 10MB
    	return resolver;
    }
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// PHẦN CẤU HÌNH CHO STATIC FILE
    	registry
    		.addResourceHandler("/**")
    		.addResourceLocations("/WEB-INF/static/");
    	
    	// PHẦN CẤU HÌNH CHO SWAGGER
    	registry
		.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
    	
    	registry
		.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/api/**")
    	.allowedOrigins("*")
		.allowedMethods("PUT", "GET", "POST", "DELETE")
		.allowCredentials(false).maxAge(3600);
    }
}
