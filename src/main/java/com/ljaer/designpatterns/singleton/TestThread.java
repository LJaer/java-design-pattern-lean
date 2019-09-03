package com.ljaer.designpatterns.singleton;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class TestThread {

	public static void main(String[] args) {
		//启动100线程同时去抢CPU
		int count = 100;

		CountDownLatch latch = new CountDownLatch(count);
		//发令枪，测试并发经常用到
		CountDownLatch startGate = new CountDownLatch(1);
		//Set默认去去重的，set是本身线程不安全的
		final Set<Singleton1> syncSet = Collections.synchronizedSet(new HashSet<Singleton1>());

		Runnable runnable = () -> {
			Singleton1 a = Singleton1.getInstance();
			syncSet.add(a);
			System.out.println(a);
		};

		for (int i = 0; i < count; i++) {
			new Thread(() -> {
				try{
					// 使线程在此等待，当开始门打开时，一起涌入门中
					startGate.await();
					runnable.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// 将结束门减1，减到0时，就可以开启结束门了
					latch.countDown();
				}
			}).start();
		}

		try {
			// 因开启门只需一个开关，所以立马就开启开始门
			startGate.countDown();
			latch.await();//等待所有线程全部完成，最终输出结果
			System.out.println(syncSet.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
