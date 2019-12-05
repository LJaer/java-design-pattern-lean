package com.ljaer.designpatterns.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibTest {
    public static void main(String[] args) throws Exception {

        //利用 CGlib 的代理类可以将内存中的 .class 文件写入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_class/");

        Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
        obj.findLove();
    }
}
