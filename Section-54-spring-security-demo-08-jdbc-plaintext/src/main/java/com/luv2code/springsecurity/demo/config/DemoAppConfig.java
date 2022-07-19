package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// set up variable to hold the properies
	@Autowired
	private Environment env;
	
	// setup a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	//define a bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		
		//cretae connection pool
		ComboPooledDataSource securityDataSource =
				new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		//log the connection props
		//don't log password :-)
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		//set db connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(
				getIntproperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getIntproperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getIntproperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntproperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	
	//need a helper method 
	//read env prop and turn to int
	//as env props come in string
	private int getIntproperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		//System.out.println("error: " + propVal);
		
		//convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

}
