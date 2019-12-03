package com.ljaer.designpatterns.proxy.myjdk;

import com.ljaer.designpatterns.proxy.jdk.Customer;
import com.ljaer.designpatterns.proxy.jdk.Person;

public class ZkTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new ZKMeipo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
