package com.ljaer.designpatterns.proxy.jdk;

public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有车");
    }
}
