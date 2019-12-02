package com.ljaer.designpatterns.singleton;

import java.io.*;

/**
 * 单例序列化测试
 */
public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //输出结果：
        //com.ljaer.designpatterns.singleton.SeriableSingleton@568db2f2
        //com.ljaer.designpatterns.singleton.SeriableSingleton@45ee12a7
        //false

        SeriableSingletonFinal s3 = null;
        SeriableSingletonFinal s4 = SeriableSingletonFinal.getInstance();

        FileOutputStream fos2 = null;

        try {
            fos2 = new FileOutputStream("SeriableSingleton2.obj");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(s4);
            oos2.flush();
            oos2.close();

            FileInputStream fis2 = new FileInputStream("SeriableSingleton2.obj");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            s3 = (SeriableSingletonFinal) ois2.readObject();
            ois2.close();

            System.out.println(s3);
            System.out.println(s4);
            System.out.println(s3==s4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //输出结果：
        //com.ljaer.designpatterns.singleton.SeriableSingletonFinal@16b98e56
        //com.ljaer.designpatterns.singleton.SeriableSingletonFinal@16b98e56
        //true
    }
}
