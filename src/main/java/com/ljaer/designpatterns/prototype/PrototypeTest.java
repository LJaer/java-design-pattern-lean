package com.ljaer.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        //创建一个具体的需要创建的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        //填充属性，方便测试
        concretePrototype.setAge(18);
        List hobbies = new ArrayList();
        hobbies.add("学习");
        concretePrototype.setHobbies(hobbies);

        //创建 Client 对象，准备开始克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象中的引用类型地址值: " + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值: " + concretePrototype.getHobbies());
        System.out.println("对象地址比较：" + (concretePrototypeClone.getHobbies() == concretePrototype.getHobbies()));
    }

    //输出结果
    //克隆对象中的引用类型地址值: [学习]
    //原对象中的引用类型地址值: [学习]
    //对象地址比较：true
}
