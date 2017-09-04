package com.uts.config.mysql;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by yxf on 2017/9/3.
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig {
    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Autowired
    private DruidDataSourceSettings druidDataSource;

    public static String DRIVER_CLASSNAME;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properdtyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {

        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
//      reg.setAsyncSupported(true);
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny", "/deny");
//      reg.addInitParameter("loginUsername", "yxf");
//      reg.addInitParameter("loginPassword", "yxf");
        logger.info(" druid console manager init : {} ", reg);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
        logger.info(" druid filter register : {} ", filterRegistrationBean);
        return filterRegistrationBean;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(druidDataSource.getDriverClassName());
        DRIVER_CLASSNAME = druidDataSource.getDriverClassName();
        ds.setUrl(druidDataSource.getUrl());
        ds.setUsername(druidDataSource.getUsername());
        ds.setPassword(druidDataSource.getPassword());
        ds.setInitialSize(druidDataSource.getInitialSize());
        ds.setMinIdle(druidDataSource.getMinIdle());
        ds.setMaxIdle(druidDataSource.getMaxIdle());
        ds.setMaxActive(druidDataSource.getMaxActive());
        ds.setTimeBetweenEvictionRunsMillis(druidDataSource.getTimeBetweenEvictionRunsMillis());
        ds.setMinEvictableIdleTimeMillis(druidDataSource.getMinEvictableIdleTimeMillis());
        ds.setValidationQuery(druidDataSource.getValidationQuery());
        ds.setTestWhileIdle(druidDataSource.isTestWhileIdle());
        ds.setTestOnBorrow(druidDataSource.isTestOnBorrow());
        ds.setTestOnReturn(druidDataSource.isTestOnReturn());
        ds.setPoolPreparedStatements(druidDataSource.isPoolPreparedStatements());
        ds.setMaxPoolPreparedStatementPerConnectionSize(druidDataSource.getMaxPoolPreparedStatementPerConnectionSize());
        ds.setFilters(druidDataSource.getFilters());
        ds.setConnectProperties(druidDataSource.getConnectionProperties());
        logger.info("DruidDataSourceConfig datasource in, DruidDataSource[{}]", ds);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource());
        return txManager;

    }
}
