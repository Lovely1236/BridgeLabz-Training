package com.clinic.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HikariConnectionPool {

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(
            @Value("${clinic.db.url}") String url,
            @Value("${clinic.db.username}") String username,
            @Value("${clinic.db.password}") String password,
            @Value("${clinic.db.maximum-pool-size:10}") int maximumPoolSize,
            @Value("${clinic.db.minimum-idle:2}") int minimumIdle) {
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(url);
        configuration.setUsername(username);
        configuration.setPassword(password);
        configuration.setMaximumPoolSize(maximumPoolSize);
        configuration.setMinimumIdle(minimumIdle);
        configuration.setPoolName("health-clinic-pool");
        configuration.setConnectionTimeout(10_000);
        return new HikariDataSource(configuration);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
