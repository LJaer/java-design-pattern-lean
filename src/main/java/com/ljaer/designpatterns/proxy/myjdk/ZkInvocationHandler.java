package com.ljaer.designpatterns.proxy.myjdk;

import java.lang.reflect.Method;

public interface ZkInvocationHandler {
    Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
