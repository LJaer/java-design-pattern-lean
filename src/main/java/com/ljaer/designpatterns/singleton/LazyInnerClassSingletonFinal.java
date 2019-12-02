package com.ljaer.designpatterns.singleton;


/**
 * 防止反射破坏单例
 */
public class LazyInnerClassSingletonFinal {

	//默认不加载
	private static class LazyHolder {
		private static final LazyInnerClassSingletonFinal INSTANCE = new LazyInnerClassSingletonFinal();
	}

	//如果没有使用，则内部类是不加载的
	private LazyInnerClassSingletonFinal(){
		if(LazyHolder.INSTANCE != null){
			throw new RuntimeException("不允许创建多个实例");
		}
	}

	public static final LazyInnerClassSingletonFinal getInstance() {
		return LazyHolder.INSTANCE;
	}

}