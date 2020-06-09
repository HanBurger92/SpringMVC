package com.springmvc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
// define target package that will be scanned by Spring
@ComponentScan(basePackages = {"com.springmvc"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@EnableTransactionManagement
@MapperScan("com.springmvc.mapper")
public class RootConfig implements TransactionManagementConfigurer {

    /**
     * Database java-based Configuration ---- to connect to the Database
     * @return BasicDataSource
     */
    @Bean
    public BasicDataSource initDataSource(){

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL 8.0 need new driverClass instead of the old one
        ds.setUrl("jdbc:mysql://localhost:3306/aoxing?serverTimezone=GMT"); // TimeZone is to prevent BUG of the 8.0 MySQL
        ds.setUsername("root");
        ds.setPassword("duoduo9922");
        return ds;
    }

    /**
     * SqlSessionFactoryBean Configuration (MyBatis)
     * @return SqlSessionFactoryBean
     */
    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean initSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(initDataSource());
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource); // read MyBatis configuration form specific xml file
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml")); // To tell the system where to find mapper
        return sqlSessionFactoryBean;
    }

    /**
     * AutoScan to find Mybatis Mapper Interface
     * @return MapperScannerConfigurer
     */
    @Bean
    public MapperScannerConfigurer initMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.*"); // To tell the System which package to scan and find mapper
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setAnnotationClass(Repository.class); // Annotation configuration
        return mapperScannerConfigurer;
    }

    /**
     * To manipulate transaction with annotation @Transactional
     * @return
     */
    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }

}
