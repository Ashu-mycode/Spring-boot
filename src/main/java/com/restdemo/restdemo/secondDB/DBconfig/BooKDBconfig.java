
/*
 * This class BooKDBconfig 
 * For second Database access in project
 * three bean class define
 * DataSource
 * EntityManager
 * TransactionManager 
 * */

package com.restdemo.restdemo.secondDB.DBconfig;

import java.util.HashMap;
import java.util.Map;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;

import org.hibernate.cfg.Environment;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "bookEntityManagerFactory", 
		transactionManagerRef = "bookTransactionManagerFactory", 
		basePackages = "com.restdemo.restdemo.secondDB.repository"
)
public class BooKDBconfig {

	
	@Bean(name = "bookdatasource")
	@ConfigurationProperties(prefix = "spring.lib.datasource")
	public DataSource bookdatasource() {
		
		return (DataSource) DataSourceBuilder.create().build();
	}

    
	
	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean EntityManagerFactoryBean(EntityManagerFactoryBuilder builder, 
			@Qualifier("bookdatasource") DataSource bookdatasource) {
		//Map<String, Object> properties = new HashMap<>();
		//properties.put("hibernet.hbm2ddl.auto", "update");
		//properties.put("hibernet.dialect", "org.hibernet.dialect.MYSQL5Dialect");
		return builder.dataSource(bookdatasource())
				      .packages("com.restdemo.restdemo.secondDB.entities").persistenceUnit("Book").build();
		
	}
	
	
	@Bean(name = "booktransactionManagerFactory")
	public PlatformTransactionManager transactionManager(@Qualifier("bookEntityManagerFactory")EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	
}
