package com.uts.config.mysql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by yxf on 2017/9/3.
 */
@Configuration
@MapperScan(basePackages = "com.uts.dao.mysql",sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisDataSourceConfig {

    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;

    @Bean(name ="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(){
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory =null;
        try {
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources("classpath:mybatis/mapper/mysql/*.xml"));

            sqlSessionFactory = sessionFactoryBean.getObject();
            sqlSessionFactory.getConfiguration().setCacheEnabled(Boolean.TRUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
           throw new RuntimeException();
        }
        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory ){
          return new SqlSessionTemplate(sqlSessionFactory);
    }

}
