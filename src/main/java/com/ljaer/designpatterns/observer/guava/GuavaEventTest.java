package com.ljaer.designpatterns.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuaveEvent guaveEvent = new GuaveEvent();
        eventBus.register(guaveEvent);
        eventBus.post("zhangsan");
    }
}
