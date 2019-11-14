package com.avic.zemic.first.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mapstruct.Qualifier;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public class DataSourceConfigration {

//    配置主数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    @Primary
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "oneSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory getSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("oneDataSource"));
//        return bean.getObject();
//    }

}
