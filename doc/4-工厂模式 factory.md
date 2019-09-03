[TOC]

# 工厂模式 factory

## 1-定义

- 抽象工厂模式：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类。
- 工厂方法模式：定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。
- 简单工厂模式



## 2-基础Car接口和Car接口实现

Car.java

```java
package com.ljaer.designpatterns.factory;

//产品接口
//汽车需要满足一定的标准
public interface Car {

	//规定汽车的品牌
	String getName();

}
```

Audi.java

```java
package com.ljaer.designpatterns.factory;

public class Audi implements Car{

	@Override
	public String getName() {
		return "Audi";
	}

}
```

Benz.java

```java
package com.ljaer.designpatterns.factory;

public class Benz implements Car{

	@Override
	public String getName() {
		return "Benz";
	}

}
```

Bmw.java

```java
package com.ljaer.designpatterns.factory;

public class Bmw implements Car{

	@Override
	public String getName() {
		return "BMW";
	}

}
```



## 3-简单工厂模式

SimpleFactory.java

```java
package com.ljaer.designpatterns.factory.simple;

import com.ljaer.designpatterns.factory.Audi;
import com.ljaer.designpatterns.factory.Benz;
import com.ljaer.designpatterns.factory.Bmw;
import com.ljaer.designpatterns.factory.Car;

//对于这个工厂来说(太强大了)
//为什么？
//这个工厂啥都能干(不符合现实)
//编码也是一种艺术(融汇贯通),艺术来源于生活，回归到生活的
public class SimpleFactory {

	//实现统一管理、专业化管理
	//如果没有工厂模式，小作坊，没有执行标准的
	//如果买到三无产品（没有标准）
	//卫生监督局工作难度会大大减轻

	//中国制造(按人家的标准执行)
	//中国制造向中国创造改变(技术不是问题了，问题是什么？思维能力)
	//码农就是执行标准的人
	//系统架构师，就是制定标准的人

	//不只做一个技术者，更要做一个思考者
	public Car getCar(String name){
		if("BMW".equalsIgnoreCase(name)){
			//Spring中的工厂模式
			//Bean
			//BeanFactory（生成Bean）
			//单例的Bean
			//被代理过的Bean
			//最原始的Bean（原型）
			//List类型的Bean
			//作用域不同的Bean

			//getBean
			//非常的紊乱，维护困难
			//解耦（松耦合开发）
			return new Bmw();
		}else if("Benz".equalsIgnoreCase(name)){
			return new Benz();
		}else if("Audi".equalsIgnoreCase(name)){
			return new Audi();
		}else{
			System.out.println("这个产品产不出来");
			return null;
		}
	}

}
```

SimpleFactoryTest.java

```java
package com.ljaer.designpatterns.factory.simple;


import com.ljaer.designpatterns.factory.Car;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		//这边就是我们的消费者
		Car car = new SimpleFactory().getCar("audi");
		System.out.println(car.getName());
	}
}
```

## 4-工厂方法模式

Factory.java

```java
package com.ljaer.designpatterns.factory.func;


import com.ljaer.designpatterns.factory.Car;

//工厂接口，就定义了所有工厂的执行标准
public interface Factory {

	//符合汽车上路标准
	//尾气排放标准
	//电子设备安全系数
	//必须配备安全带、安全气囊
	//轮胎的耐磨程度
	Car getCar();

}
```

AudiFactory.java

```java
package com.ljaer.designpatterns.factory.func;


import com.ljaer.designpatterns.factory.Audi;
import com.ljaer.designpatterns.factory.Car;

public class AudiFactory implements Factory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
```

BenzFactory.java

```java
package com.ljaer.designpatterns.factory.func;

import com.ljaer.designpatterns.factory.Benz;
import com.ljaer.designpatterns.factory.Car;

public class BenzFactory implements Factory {

    @Override
    public Car getCar() {
        return new Benz();
    }

}
```

BmwFactory.java

```java
package com.ljaer.designpatterns.factory.func;

import com.ljaer.designpatterns.factory.Bmw;
import com.ljaer.designpatterns.factory.Car;

public class BmwFactory implements Factory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
```

FactoryTest.java

```java
package com.ljaer.designpatterns.factory.func;

public class FactoryTest {

	public static void main(String[] args) {

		//工厂方法模式
		//各个产品的生产商，都拥有各自的工厂
		//生产工艺，生成的高科技程度都是不一样的
		Factory factory = new AudiFactory();
		System.out.println(factory.getCar());

		//需要用户关心，这个产品的生产商
		factory = new BmwFactory();
		System.out.println(factory.getCar());

		//增加的代码的使用复杂度

		//抽象工厂模式
	}

}
```

## 5-抽象工厂模式

AbstractFactory.java

```java
package com.ljaer.designpatterns.factory.abstr;

import com.ljaer.designpatterns.factory.Car;

public abstract class AbstractFactory {

	protected abstract Car getCar();

	//这段代码就是动态配置的功能
	//固定模式的委派
	public Car getCar(String name){
		if("BMW".equalsIgnoreCase(name)){
			return new BmwFactory().getCar();
		}else if("Benz".equalsIgnoreCase(name)){
			return new BenzFactory().getCar();
		}else if("Audi".equalsIgnoreCase(name)){
			return new AudiFactory().getCar();
		}else{
			System.out.println("这个产品产不出来");
			return null;
		}
	}
}
```

DefaultFactory.java

```java
package com.ljaer.designpatterns.factory.abstr;

import com.ljaer.designpatterns.factory.Car;

public class DefaultFactory extends AbstractFactory {

	private AudiFactory defaultFactory = new AudiFactory();
	
	public Car getCar() {
		return defaultFactory.getCar();
	}

}
```

AudiFactory.java

```java
package com.ljaer.designpatterns.factory.abstr;


import com.ljaer.designpatterns.factory.Audi;
import com.ljaer.designpatterns.factory.Car;

//具体的业务逻辑封装
public class AudiFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Audi();
	}

}
```

BenzFactory.java

```java
package com.ljaer.designpatterns.factory.abstr;

import com.ljaer.designpatterns.factory.Benz;
import com.ljaer.designpatterns.factory.Car;

public class BenzFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Benz();
	}

}
```

BmwFactory.java

```java
package com.ljaer.designpatterns.factory.abstr;


import com.ljaer.designpatterns.factory.Bmw;
import com.ljaer.designpatterns.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	public Car getCar() {
		return new Bmw();
	}

}
```

