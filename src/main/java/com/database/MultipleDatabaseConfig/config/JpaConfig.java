package com.database.MultipleDatabaseConfig.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.TransactionManager;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean(name = "oracleEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean OracleEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("oracleDatasourceConfig")DataSource dataSource){

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.show_sql", true);
        return builder.dataSource(dataSource)
                .packages("com.database.MultipleDatabaseConfig.oracle.entity")
                .properties(jpaProperties)
                .persistenceUnit("oracle").build();
    }


    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean MySqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDatasourceConfig") DataSource dataSource){

        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.show_sql", true);

        return builder.dataSource(dataSource)
                .packages("com.database.MultipleDatabaseConfig.mysql.entity")
                .properties(jpaProperties)
                .persistenceUnit("mysql").build();
    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager oracleTransactionManager(
            @Qualifier("oracleEntityManagerFactory") EntityManagerFactory factory){

        return new JpaTransactionManager(factory);
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }
}
