package io.pivotal.cna.config.data;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"cloud"})
public class RelationalCloudDataSourceConfig extends AbstractCloudConfig
{
    @Bean
    public DataSource dataSource() {return connectionFactory().dataSource();}

//    @Bean
//    public ConnectionFactory rabbitConnectionFactory(){return connectionFactory().rabbitConnectionFactory();}

//    @Bean
//    public DataSource gemfirexdDataSource(){return connectionFactory().dataSource();}

//    @Bean
//    public Configuration hadoopConfiguration(){return connectionFactory().service(Configuration.class);}

}