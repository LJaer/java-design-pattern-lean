package com.ljaer.designpatterns.observer.studentobservable;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Student  student = (Student) o;
        Question question = (Question) arg;
        System.out.println("========================");
        System.out.println(name + "老师，你好!\n" +
                "您收到了一个来自“"+student.getName() +"”的提问，希望您解答，问题内容如下: \n "
                + question.getContent() + "\n" + "提问者: " + question.getUsername());
    }
}
