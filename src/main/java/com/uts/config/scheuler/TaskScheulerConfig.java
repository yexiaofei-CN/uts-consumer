package com.uts.config.scheuler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yxf on 2017/9/4.
 */
@Configuration
@EnableScheduling //启动定时
public class TaskScheulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskScheuler());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheuler(){
        return Executors.newScheduledThreadPool(100);
    }
}
