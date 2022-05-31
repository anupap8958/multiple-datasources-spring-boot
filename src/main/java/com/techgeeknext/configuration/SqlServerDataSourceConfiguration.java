package com.techgeeknext.configuration;

import com.techgeeknext.entities.people.People;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.techgeeknext.repository.people",
        entityManagerFactoryRef = "sqlserverEntityManagerFactory",
        transactionManagerRef= "sqlserverTransactionManager")
public class SqlServerDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("sqlserver.datasource")
    public DataSourceProperties sqlserverDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("sqlserver.datasource.configuration")
    public DataSource sqlserverDataSource() {
        return sqlserverDatasourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "sqlserverEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlserverEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                @Qualifier("sqlserverDataSource") DataSource dataSource) {
        return builder
                .dataSource(sqlserverDataSource())
                .packages(People.class)
                .persistenceUnit("db2")
                .build();
    }

    @Bean
    public PlatformTransactionManager peopleTransactionManager(
            final @Qualifier("sqlserverEntityManagerFactory") LocalContainerEntityManagerFactoryBean sqlserverEntityManagerFactory) {
        return new JpaTransactionManager(sqlserverEntityManagerFactory.getObject());
    }

    @Bean("peopleJdbcTemplate")
    public JdbcTemplate peopleJdbcTemplate(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
