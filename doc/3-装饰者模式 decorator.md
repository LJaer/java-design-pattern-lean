[TOC]

# 装饰者模式 decorator

## 1-抽象调料装饰者

CondimentDecorator.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 抽象调料装饰者
 */
public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public abstract String getDescription();
}
```

## 2-继承抽象调料

Mocha.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}
```

Soy.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 大豆
 */
public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
```

Whip.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;
 
public class Whip extends CondimentDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
```

## 3-基础饮料

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 饮料
 */
public abstract class Beverage {
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
```

## 4-继承饮料

DarkRoast.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 烘焙
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}
```

Decaf.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 脱咖啡因咖啡
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf Coffee";
    }

    public double cost() {
        return 1.05;
    }
}
```

Espresso.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 浓咖啡
 */
public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}
```

HouseBlend.java

```java
package com.ljaer.designpatterns.decorator.starbuzz;

/**
 * 混合咖啡
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return .89;
    }
}
```

## 5-测试类

```java
package com.ljaer.designpatterns.decorator.starbuzz;

public class StarbuzzCoffee {

    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        // 双倍mocka
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());

        //豆浆、摩卡、奶泡
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());
    }
}
```

## 6-执行结果

```
Espresso $1.99
Dark Roast Coffee, Mocha, Mocha, Whip $1.49
House Blend Coffee, Soy, Mocha, Whip $1.34
```

