package com.ljaer.designpatterns.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
	public static Singleton INSTANCE = new Singleton();   
	protected Singleton() {  }   
	private Object readResolve() {   
		return INSTANCE;   
	}
}
