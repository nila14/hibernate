package org.cts.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "org.cts")
@PropertySource("classpath:database.properties")
public class MyConfig {
	@Value("${driver}")
	String driver;
	@Value("${url}")
	String url;
	@Value("${username}")
	String uname;
	@Value("${password}")
	String pwd;
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(uname);
		dataSource.setPassword(pwd);
		return dataSource;
	}
	@Bean
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	public PropertyPlaceholderConfigurer getPropertyPlaceHolderConfigurer()
	{
		return new PropertyPlaceholderConfigurer();
	}
	
	
}
