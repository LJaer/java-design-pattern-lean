package com.ljaer.designpatterns.observer.guava;

import com.google.common.eventbus.Subscribe;

//创建监听事件
public class GuaveEvent {
    @Subscribe
    public void subscribe(String str){
        //业务逻辑
        System.out.println("执行 subscribe 方法，传入的参数是：" + str);
    }
}
