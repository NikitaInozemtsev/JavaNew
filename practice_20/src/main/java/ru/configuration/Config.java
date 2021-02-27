package ru.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "ru.repositories")
@EnableAspectJAutoProxy
public class Config {

}
