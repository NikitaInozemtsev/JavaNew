package ru.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * The class describes the configuration of the entire project
 */
@Configuration
public class Config {

    /**
     * Initializing a database connection
     *
     * @return properties to my DB
     */
    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://10.10.10.142:5432/neSkajy");
        config.setUsername("inozemcevns");
        config.setPassword("neSkajy");

        return new HikariDataSource(config);
    }

    /**
     * Method creates a Hibernate SessionFactory.
     *
     * @param dataSource properties to mu DB
     * @return Hibernate SessionFactory
     */
    @Bean
    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        sessionFactoryBean.setPackagesToScan("ru");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    /**
     * Method allow transaction in project
     *
     * @param factoryBean
     * @return transaction manager
     */
    @Bean
    public PlatformTransactionManager
    platformTransactionManager(LocalSessionFactoryBean factoryBean) {
        HibernateTransactionManager transactionManager = new
                HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }

}
