package com.uts.task;

import com.uts.config.mysql.DruidDataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yxf on 2017/9/4.
 */
@Component
public class test {
    private static Logger logger = LoggerFactory.getLogger(test.class);
    @Scheduled(initialDelay =1000, fixedDelay = 3000)
    public void test(){
       logger.info("schedulde test...");
    }
}
