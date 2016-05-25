package com.shulyaq.spring.mvc.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DbConfiguration {

    @Autowired
    private DbConfigBean dbConfigBean;

    @Autowired
    private Environment environment;


    @Bean
    public DbConfigBean dbConfigBean() {
        return new DbConfigBean();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(".com.shulyaq.spring.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbConfigBean.getDriverClassName());
        dataSource.setUrl(dbConfigBean.getJdbcUrl());
        dataSource.setUsername(dbConfigBean.getUsername());
        dataSource.setPassword(dbConfigBean.getPassword());
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dbConfigBean.getHibernateDialect());
        properties.put("hibernate.show_sql", dbConfigBean.getHibernateShowSql());
        properties.put("hibernate.format_sql", dbConfigBean.getHibernateFormatSql());
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
