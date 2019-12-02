package com.ljaer.designpatterns.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class JdkProxyTest {
    public static void main(String[] args) throws IOException {
        Person obj = (Person) new JDKMeipo().getInstance(new Customer());
        obj.findLove();

        //通过反编译工具可以查看源代码
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();

        //用jad反编译 jad E://$Proxy0.class
    }
}
