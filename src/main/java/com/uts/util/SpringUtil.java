package com.uts.util;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by yxf on 2017/9/4.
 */
public class SpringUtil {

    private static ConfigurableApplicationContext ctx;

    public static void setConfigContext(ConfigurableApplicationContext ctx) {
        SpringUtil.ctx = ctx;
    }

    public static ConfigurableApplicationContext getConfigurableApplicationContext() {
        return ctx;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getConfigurableApplicationContext().getBean(clazz);
    }

    public static Object getBean(String name) {
        return getConfigurableApplicationContext().getBean(name);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getConfigurableApplicationContext().getBean(name, clazz);
    }


}
