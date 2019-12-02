package com.ljaer.designpatterns.singleton;

/**
 * 枚举式单例模式
 * 解决序列化单例多次创建
 *
 * 看反编译文件实际问饿汉单例模式
 *     static
 *     {
 *         INSTANCE = new EnumSingleton("INSTANCE", 0);
 *         $VALUES = (new EnumSingleton[] {
 *             INSTANCE
 *         });
 *     }
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
