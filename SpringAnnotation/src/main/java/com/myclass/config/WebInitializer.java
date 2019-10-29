package com.myclass.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*CẤU HÌNH DispatcherServlet*/
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * tương ứng <servlet> <servlet-name>mvcServlet</servlet-name>
	 * <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-
	 * class> <!-- <init-param> <param-name>contextConfigLocation</param-name>
	 * <param-value>/WEB-INF/mvc-servlet.xml</param-value> </init-param> -->
	 * <load-on-startup>1</load-on-startup> <!-- Tạo servlet ngay lần đầu tiên -->
	 * </servlet>
	 * 
	 */

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebMvcConfig.class };
	}

	/*
	 * Tương ứng servlet-mapping <servlet-mapping>
	 * <servlet-name>mvcServlet</servlet-name> <url-pattern>/</url-pattern>
	 * </servlet-mapping>
	 * 
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
