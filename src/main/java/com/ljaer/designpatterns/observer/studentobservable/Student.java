package com.ljaer.designpatterns.observer.studentobservable;

import java.util.Observable;

public class Student extends Observable {

    private String name = "学生小明";
    private static Student student = null;

    private Student() {
    }

    public static Student getInstance() {
        if (null == student) {
            student = new Student();
        }
        return student;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "在" + this.name + "上提交了一个问题。" );
        setChanged();
        notifyObservers(question);
    }
}
