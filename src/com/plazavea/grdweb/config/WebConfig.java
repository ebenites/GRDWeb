package com.plazavea.grdweb.config;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement // Enable Transaction
@EnableAspectJAutoProxy	// Enable Aspect
@ComponentScan({ "com.plazavea.grdweb.*" })
@PropertySource("classpath:jdbc.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

	protected static final Logger log = Logger.getLogger(WebConfig.class);
	
	@Autowired
	private Environment env;
	
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springsecurity?autoReconnect=true&amp;zeroDateTimeBehavior=convertToNull");
//	    driverManagerDataSource.setUsername("root");
//	    driverManagerDataSource.setPassword("");
//	    return driverManagerDataSource;
//	}
	
	@Bean(name = "dataSource")
    public BasicDataSource dataSource() { // DataSource Commons DBCP, use properties in jdbc.properties
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }
	
//	@Bean(name = "dataSource")
//	public DataSource dataSource(){	// DataSource JNDI, use properties in /META-INF/context.xml
//	    JndiObjectFactoryBean jndiFactory = new JndiObjectFactoryBean();
//	    jndiFactory.setJndiName("java:comp/env/jdbc/springsecurity");
//	    try {
//			jndiFactory.afterPropertiesSet();
//		} catch (Exception e) {
//			log.error(e);
//		}
//	    return (DataSource) jndiFactory.getObject();
//	}
	
	@Bean
    public JdbcTemplate jdbcTemplate() {   
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
	
	@Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("java.lang.Throwable", "error");
		exceptionResolver.setExceptionMappings(mappings);
		return exceptionResolver;
	}

}
