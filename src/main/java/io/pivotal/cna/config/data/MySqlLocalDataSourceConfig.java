package io.pivotal.cna.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("mysql-local")
public class MySqlLocalDataSourceConfig extends AbstractLocalDataSourceConfig
{
    @Bean
    public DataSource dataSource() {
        return createBasicDataSource("jdbc:mysql://localhost/cities", "com.mysql.jdbc.Driver", "", "");
    }

}