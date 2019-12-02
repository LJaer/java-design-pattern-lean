package com.ljaer.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射破坏单例
 */
public class ReflectDestroySingleTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = LazyInnerClassSingleton.class;
        //通过反射获取私有构造方法
        Constructor c = clazz.getDeclaredConstructor(null);
        //强制访问
        c.setAccessible(true);
        //暴力初始化
        Object o1 = c.newInstance();
        //调用两次构造方法，相当于 "new" 了两次，犯了原则性错误
        Object o2 = c.newInstance();
        System.out.println(o1==o2);

        Class<?> clazz2 = LazyInnerClassSingletonFinal.class;
        //通过反射获取私有构造方法
        Constructor c2 = clazz2.getDeclaredConstructor(null);
        //强制访问
        c2.setAccessible(true);
        //暴力初始化
        Object o3 = c2.newInstance();
        //第二次调用，会报错
        Object o4 = c.newInstance();
        System.out.println(o3==o4);
    }

}
