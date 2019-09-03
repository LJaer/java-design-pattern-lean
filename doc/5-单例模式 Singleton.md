[TOC]

# 单例模式 Singleton

## 1-急切实例化

Singleton.java

```java
package com.ljaer.designpatterns.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
	public static Singleton INSTANCE = new Singleton();   
	protected Singleton() {  }   
	private Object readResolve() {   
		return INSTANCE;   
	}
}
```

## 2-懒汉式单例类-线程不安全

存在多线程问题

```java
package com.ljaer.designpatterns.singleton;

//懒汉式单例类.在第一次调用的时候实例化自己
public class Singleton1 {
	//1、第一步先将构造方法私有化
	private Singleton1() {}
	//2、然后声明一个静态变量保存单例的引用
	private static Singleton1 single = null;
	//3、通过提供一个静态方法来获得单例的引用
	//不安全的
	public static Singleton1 getInstance() {
		if (single == null) {
			single = new Singleton1();
		}
		return single;
	}
}
```

## 3-懒汉式单例-保证线程安全

Singleton2.java

```java
package com.ljaer.designpatterns.singleton;

//懒汉式单例.保证线程安全
public class Singleton2 {
	//1、第一步先将构造方法私有化
	private Singleton2() {}
	//2、然后声明一个静态变量保存单例的引用
	private static Singleton2 single=null;
	//3、通过提供一个静态方法来获得单例的引用
	//为了保证多线程环境下正确访问，给方法加上同步锁synchronized
	//慎用  synchronized 关键字，阻塞，性能非常低下的
	//加上synchronized关键字以后，对于getInstance()方法来说，它始终单线程来访问
	//没有充分利用上我们的计算机资源，造成资源的浪费
	public static synchronized Singleton2 getInstance() {
		if (single == null) {
			single = new Singleton2();
		}
		return single;
	}
}
```

## 4-懒汉式单例-双重锁检查

Singleton3.java

```java
package com.ljaer.designpatterns.singleton;

//懒汉式单例.双重锁检查
public class Singleton3 {
	//1、第一步先将构造方法私有化
	private Singleton3() {}
	//2、然后声明一个静态变量保存单例的引用
	private volatile static Singleton3 single=null;
	//3、通过提供一个静态方法来获得单例的引用
	//为了保证多线程环境下的另一种实现方式，双重锁检查
	//性能，第一次的时候
	public static Singleton3 getInstance() {
		if (single == null) {
			synchronized (Singleton3.class) {
				if (single == null) {
					single = new Singleton3();
				}
			}
		}
		return single;
	}
}
```

## 5-最优-懒汉式(静态内部类)

Singleton4.java

```java
package com.ljaer.designpatterns.singleton;

//懒汉式（静态内部类）
//这种写法，即解决安全问题，又解决了性能问题
//这个代码，没有浪费一个字
public class Singleton4 {

	//1、先声明一个静态内部类
	//private 私有的保证别人不能修改
	//static 保证全局唯一
	private static class LazyHolder {
		//final 为了防止内部误操作，代理模式，cgLib的代理模式
		private static final Singleton4 INSTANCE = new Singleton4();
	}
	//2、将默认构造方法私有化
	private Singleton4 (){}
	//相当于有一个默认的public的无参的构造方法，就意味着在代码中随时都可以new出来

	//3、同样提供静态方法获取实例
	//final 确保别人不能覆盖
	public static final Singleton4 getInstance() {

		//方法中的逻辑，是要在用户调用的时候才开始执行的
		//方法中实现逻辑需要分配内存，也是调用时才分配的
		return LazyHolder.INSTANCE;
	}

//	static int a = 1;
//	//不管该class有没有实例化，static静态块总会在classLoader执行完以后，就加载完毕
//	static{
//		//静态块中的内容，只能访问静态属性和静态方法
//		//只要是静态方法或者属性，直接可以用Class的名字就能点出来
//		Singleton4.a = 2;
//		//JVM 内存中的静态区，这一块的内容是公共的
//	}
}

//我们所写的所有的代码，在java的反射机制面前，都是裸奔的
//反射机制是可以拿到private修饰的内容的
//我们可以理解成即使加上private也不靠谱（按正常套路出牌，貌似可以）


//类装载到JVM中过程
//1、从上往下(必须声明在前，使用在后)
//先属性、后方法
//先静态、后动态
```

## 6-类名注册

Singleton6.java

```java
package com.ljaer.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

//类似Spring里面的方法，将类名注册，下次从里面直接获取。
public class Singleton6 {
    private static Map<String, Singleton6> map = new HashMap<String, Singleton6>();

    static {
        Singleton6 single = new Singleton6();
        map.put(single.getClass().getName(), single);
    }

    //保护的默认构造子
    protected Singleton6() {
    }

    //静态工厂方法,返还此类惟一的实例
    public static Singleton6 getInstance(String name) {
        if (name == null) {
            name = Singleton6.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton6) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
```

