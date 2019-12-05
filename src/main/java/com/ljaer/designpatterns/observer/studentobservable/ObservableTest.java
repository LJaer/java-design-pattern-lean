package com.ljaer.designpatterns.observer.studentobservable;

public class ObservableTest {
    public static void main(String[] args) {
        Student student = Student.getInstance();
        Teacher teacherWang = new Teacher("teacherWang");
        Teacher teacherLi = new Teacher("teacherLi");

        student.addObserver(teacherWang);
        student.addObserver(teacherLi);

        //业务逻辑代码
        Question question = new Question();
        question.setUsername("小明");
        question.setContent("观察者设计模式适用于哪些场景?");

        student.publishQuestion(question);
    }
}
