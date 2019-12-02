package com.ljaer.designpatterns.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//类似Spring里面的方法，将类名注册，下次从里面直接获取。

/**
 * 容器式单例
 */
public class ContainerSingleton {
    //保护的默认构造器
    protected ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }


}
