package com.cicoding.integration.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * com.cicoding.integration.config
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/12/12.
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = {"secondaryDataSource"})
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
//        DataSource dataSource = DataSourceBuilder.create().build();
//        Class<? extends DataSource> aClass = dataSource.getClass();
//        return dataSource;
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://localhost:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("wj123456");
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return datasource;
    }


    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    //要启用
    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
