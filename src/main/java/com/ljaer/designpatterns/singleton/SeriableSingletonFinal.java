package com.ljaer.designpatterns.singleton;

import java.io.Serializable;

/**
 * 防止反序列化导致破坏单例模式
 * 也会存在创建两次的问题，只不过新创建的没被返回
 */
public class SeriableSingletonFinal implements Serializable {
    private static final long serialVersionUID = 8045687131678096040L;
    //序列化就是把内存中的状态通过转换成字节码的形式
    //从而转换一个 I/O 流，写入其他地方（可以是磁盘、网络I/O）
    //内存中的状态会永久保存下来

    //反序列化就是将已经持久化的字节码内容转换为 I/O 流
    //通过 I/O 流的读取，进而将读取的内容转换为 Java 对象
    //在转换过程中会重新创建对象 new

    public final static SeriableSingletonFinal INSTANCE = new SeriableSingletonFinal();
    private SeriableSingletonFinal(){}

    public static SeriableSingletonFinal getInstance(){
        return INSTANCE;
    }

    //添加该方法
    public Object readResolve(){
        return INSTANCE;
    }
}
